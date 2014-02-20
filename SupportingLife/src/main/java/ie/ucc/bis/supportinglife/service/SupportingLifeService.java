package ie.ucc.bis.supportinglife.service;

import ie.ucc.bis.supportinglife.ccm.dao.CcmAskLookSymptomsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmLookSymptomsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientClassificationDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientTreatmentDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientVisitDao;
import ie.ucc.bis.supportinglife.ccm.dao.Dao;
import ie.ucc.bis.supportinglife.ccm.dao.UserDao;
import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.ccm.domain.CcmTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.User;
import ie.ucc.bis.supportinglife.communication.PatientAssessmentComms;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;
import ie.ucc.bis.supportinglife.utilities.DateUtilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SupportingLifeService implements SupportingLifeServiceInf {

	private Map<String, Dao> daoBeans;
	
	/*******************************************************************************/
	/************************************Users**************************************/
	/*******************************************************************************/
	@Override
	public List<User> getUserByUserId(String userId) {
		UserDao userDao = (UserDao) getDaoBeans().get("UserDao");
		return userDao.getUserByUserId(userId);
	}	
	
	/*******************************************************************************/
	/***********************************Patients************************************/
	/*******************************************************************************/

	@Override
	public List<CcmPatient> getAllPatients() {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getAllPatients();
	}
	
	@Override
	public List<CcmPatient> getPatientByNationalId(String nationalId) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getPatientByNationalId(nationalId);
	}
	
	@Override
	public List<CcmPatient> getPatientByNationalHealthId(String nationalHealthId) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getPatientByNationalHealthId(nationalHealthId);
	}
	
	@Override
	public List<CcmPatient> getAllPatientsByFirstName(String firstName) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getAllPatientsByFirstName(firstName);
	}
	
	@Override
	public List<CcmPatient> getAllPatientsByNationalHealthIdFilter(String nationalHealthIdFilter) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getAllPatientsByNationalHealthIdFilter(nationalHealthIdFilter);
	}

	/**
	 * Responsible for obtaining patient reference - if it is an existing patient, we will
	 * retrieve the reference using the 'national id' or 'national health id', otherwise
	 * we will create a new CcmPatient instance.
	 * 
	 * @param patientAssessment
	 * @return
	 */
	private CcmPatient obtainCcmPatientReference(PatientAssessmentComms patientAssessment) {
		
		Date currentDate = DateUtilities.getTodaysDate();
		List<CcmPatient> ccmPatients = new ArrayList<CcmPatient>();
		
		// check national id
		if (patientAssessment.getNationalId() != null) {
			ccmPatients = getPatientByNationalId(patientAssessment.getNationalId());
		}
		
		// check national health id
		if (ccmPatients.isEmpty() && patientAssessment.getNationalHealthId() != null) {
			ccmPatients = getPatientByNationalHealthId(patientAssessment.getNationalHealthId());
		}
		
		// if no luck finding reference, create new instance
		if (ccmPatients.isEmpty()) {
			CcmPatient ccmPatient = new CcmPatient(patientAssessment.getNationalId(), patientAssessment.getNationalHealthId(),
					patientAssessment.getChildFirstName(), patientAssessment.getChildSurname(),
					patientAssessment.getBirthDate(), patientAssessment.getGender(),
					patientAssessment.getCaregiverName(), patientAssessment.getRelationship(),
					patientAssessment.getPhysicalAddress(),
					patientAssessment.getVillageTa(), currentDate, currentDate);
			return ccmPatient;
		}
		else {
			// already exisits so just need to update the 'updated' field
			ccmPatients.get(0).setUpdatedDate(currentDate);
			return ccmPatients.get(0);
		}	
	}
	
	/*******************************************************************************/
	/*********************************Visits****************************************/
	/*******************************************************************************/
	
	@Override
	@Transactional
	public Long addPatientVisit(PatientAssessmentComms patientAssessment) {
		
		// 1. retrieve or create 'patient' instance
		CcmPatient ccmPatient = obtainCcmPatientReference(patientAssessment);
		
		// 2. retrieve reference to HSA user
		List<User> hsaUsers = getUserByUserId(patientAssessment.getHsaUserId());
		
		// 3. create 'patient visit' instance
		CcmPatientVisit ccmPatientVisit = new CcmPatientVisit(ccmPatient, patientAssessment.getVisitDate(), hsaUsers.get(0));

		// 4. configurre the 'Look' symptoms
		ccmPatientVisit.setCcmPatientLookSymptoms(new CcmPatientLookSymptoms(ccmPatientVisit, ccmPatient, patientAssessment.isChestIndrawing(),
							patientAssessment.getBreathsPerMinute(), patientAssessment.isSleepyUnconscious(), patientAssessment.isPalmarPallor(),
							patientAssessment.getMuacTapeColour(), patientAssessment.isSwellingBothFeet()));
				
		// 5. configure the 'Ask + Look' symptoms
		ccmPatientVisit.setCcmPatientAskLookSymptoms(new CcmPatientAskLookSymptoms(ccmPatientVisit, ccmPatient, patientAssessment.getProblem(), 
							patientAssessment.isCough(), patientAssessment.getCoughDuration(), patientAssessment.isDiarrhoea(),
							patientAssessment.getDiarrhoeaDuration(), patientAssessment.isBloodInStool(), patientAssessment.isFever(),
							patientAssessment.getFeverDuration(), patientAssessment.isConvulsions(), patientAssessment.isDifficultyDrinkingOrFeeding(),
							patientAssessment.isUnableToDrinkOrFeed(), patientAssessment.isVomiting(), patientAssessment.isVomitsEverything(),
							patientAssessment.isRedEye(), patientAssessment.getRedEyeDuration(), patientAssessment.isDifficultySeeing(),
							patientAssessment.getDifficultySeeingDuration(), patientAssessment.getCannotTreatProblemDetails()));
		
		// 6. associate the patient with the patient visit
		ccmPatient.getCcmPatientVisitList().add(ccmPatientVisit);
		
		// 7. associate the classifications with the patient visit
		for (Map.Entry<String, String> entry : patientAssessment.getClassifications().entrySet()) {
			ccmPatientVisit.getCcmPatientClassificationList().add(new CcmPatientClassification(ccmPatientVisit, new CcmClassification(entry.getKey(), entry.getValue()), ccmPatient));
		}
		
		// 8. associate the treatments with the patient visit
		for (Map.Entry<String, String> entry : patientAssessment.getTreatments().entrySet()) {
			ccmPatientVisit.getCcmPatientTreatmentList().add(new CcmPatientTreatment(ccmPatientVisit, new CcmTreatment(entry.getKey(), entry.getValue()), ccmPatient));
		}
		
		// 9. add the patient record to the DB
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		Long slPatientId = patientDao.addPatient(ccmPatient);
		return slPatientId;
	}
	
	
	@Override
	public List<CcmPatientVisit> getPatientVisitbyVisitId(long visitId) {
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getPatientVisitbyVisitId(visitId);
	}
	
	@Override
	public List<CcmPatientVisit> getPatientVisitsbyPatientId(long patientId) {
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getPatientVisitsByPatientId(patientId);
	}
	
	@Override
	public List<CcmPatientVisit> getAllPatientVisits() {
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getAllPatientVisits();
	}
	
	@Override
	public List<CcmPatientVisit> getPatientVisits(String patientId,
												String nationalId,
												String nationalHealthId, 
												String hsaUserId, 
												Date assessmentDateFrom,
												Date assessmentDateTo, 
												List<CheckboxFormElement> lookSymptoms,
												List<CheckboxFormElement> askLookSymptoms,
												List<CheckboxFormElement> classifications, 
												List<Treatment> treatments) {
		// 1. identify symptoms selected by user
		List<CheckboxFormElement> selectedLookSymptoms = identifySelectedSymptoms(lookSymptoms);
		List<CheckboxFormElement> selectedAskLookSymptoms = identifySelectedSymptoms(askLookSymptoms);
		
		// 2. identify classifications selected by user
		List<CheckboxFormElement> selectedClassifications = identifySelectedClassifications(classifications);
		
		// 3. identify treatments selected by user
		List<Treatment> selectedTreatments = identifySelectedTreatments(treatments);

		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		return patientVisitDao.getPatientVisits(patientId, nationalId, nationalHealthId,
											hsaUserId, assessmentDateFrom,
											assessmentDateTo, selectedLookSymptoms,
											selectedAskLookSymptoms,
											selectedClassifications, selectedTreatments);
	}
	
	/*******************************************************************************/
	/*********************************Patient Symptoms******************************/
	/*******************************************************************************/
	@Override
	public List<CcmPatientLookSymptoms> getLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmLookSymptomsDao lookSymptomsDao = (CcmLookSymptomsDao) getDaoBeans().get("CcmLookSymptomsDao");
		return lookSymptomsDao.getLookSymptomsByVisit(ccmPatientVisit);
	}
	
	@Override
	public List<CcmPatientAskLookSymptoms> getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmAskLookSymptomsDao askLookSymptomsDao = (CcmAskLookSymptomsDao) getDaoBeans().get("CcmAskLookSymptomsDao");
		return askLookSymptomsDao.getAskLookSymptomsByVisit(ccmPatientVisit);		
	}
	
	/*******************************************************************************/
	/******************************Patient Classifications**************************/
	/*******************************************************************************/	
	@Override
	public List<CcmPatientClassification> getPatientClassificationsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmPatientClassificationDao patientClassificationDao = (CcmPatientClassificationDao) getDaoBeans().get("CcmPatientClassificationDao");
		return patientClassificationDao.getPatientClassificationsByVisit(ccmPatientVisit);				
	}
	
	/*******************************************************************************/
	/*******************************Patient Treatments******************************/
	/*******************************************************************************/	
	@Override
	public List<CcmPatientTreatment> getPatientTreatmentsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmPatientTreatmentDao patientTreatmentDao = (CcmPatientTreatmentDao) getDaoBeans().get("CcmPatientTreatmentDao");
		return patientTreatmentDao.getPatientTreatmentsByVisit(ccmPatientVisit);				
	}
	
	/*******************************************************************************/
	/*********************************Utility Methods*******************************/
	/*******************************************************************************/
	
	/**
	 * Utility method to identify those symptoms which have been checked
	 * by a user from a symptom list
	 * 
	 * @param symptoms
	 * 
	 * @return List<Symptom>
	 */
	private List<CheckboxFormElement> identifySelectedSymptoms(List<CheckboxFormElement> symptoms) {
		List<CheckboxFormElement> symptomsSelected = new ArrayList<CheckboxFormElement>();
		
		for (CheckboxFormElement symptom : symptoms) {
			if (symptom.isChecked()) {
				symptomsSelected.add(symptom);
			}
		}	
		return symptomsSelected;
	}

	/**
	 * Utility method to identify those classifications which have been checked
	 * by a user from a classification list
	 * 
	 * @param classifications
	 * 
	 * @return List<Classification>
	 */
	private List<CheckboxFormElement> identifySelectedClassifications(List<CheckboxFormElement> classifications) {
		List<CheckboxFormElement> classificationsSelected = new ArrayList<CheckboxFormElement>();
		
		for (CheckboxFormElement classification : classifications) {
			if (classification.getChecked()) {
				classificationsSelected.add(classification);
			}
		}	
		return classificationsSelected;
	}
	
	/**
	 * Utility method to identify those treatments which have been checked
	 * by a user from a treatment list
	 * 
	 * @param treatment
	 * 
	 * @return List<Treatment>
	 */
	private List<Treatment> identifySelectedTreatments(List<Treatment> treatments) {
		List<Treatment> treatmentsSelected = new ArrayList<Treatment>();
		
		for (Treatment treatment : treatments) {
			if (treatment.getChecked()) {
				treatmentsSelected.add(treatment);
			}
		}	
		return treatmentsSelected;
	}

	
	
	/*******************************************************************************/
	/*********************************Getters/Setters*******************************/
	/*******************************************************************************/
	public Map<String, Dao> getDaoBeans() {
		return daoBeans;
	}

	public void setDaoBeans(Map<String, Dao> daoBeans) {
		this.daoBeans = daoBeans;
	}
}
