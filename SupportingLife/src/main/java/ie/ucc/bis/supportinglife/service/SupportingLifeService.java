package ie.ucc.bis.supportinglife.service;

import ie.ucc.bis.supportinglife.ccm.dao.CcmAskLookSymptomsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmAssessmentAnalyticsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmLookSymptomsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientClassificationDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientTreatmentDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientVisitDao;
import ie.ucc.bis.supportinglife.ccm.dao.Dao;
import ie.ucc.bis.supportinglife.ccm.dao.UserDao;
import ie.ucc.bis.supportinglife.ccm.domain.CcmAssessmentAnalytics;
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
import ie.ucc.bis.supportinglife.communication.PatientAssessmentResponseComms;
import ie.ucc.bis.supportinglife.communication.SurveillanceRequestComms;
import ie.ucc.bis.supportinglife.communication.UserAuthenticationComms;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;
import ie.ucc.bis.supportinglife.surveillance.SurveillanceRecord;
import ie.ucc.bis.supportinglife.utilities.DateUtilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SupportingLifeService implements SupportingLifeServiceInf {

	private Map<String, Dao> daoBeans;
	
	/*******************************************************************************/
	/************************************Users**************************************/
	/*******************************************************************************/
	@Override
	public User getUserByUserId(String userId) {
		UserDao userDao = (UserDao) getDaoBeans().get("UserDao");
		return userDao.getUserByUserId(userId);
	}	
	
	@Override
	public Boolean registerUser(UserAuthenticationComms userDetails) {
		UserDao userDao = (UserDao) getDaoBeans().get("UserDao");
		boolean authenticatedUser = userDao.authenticateUser(userDetails.getHsaUserId(), userDetails.getPassword());
		if (authenticatedUser) {
			// user authenticated so record user registration
			userDao.registerUser(getUserByUserId(userDetails.getHsaUserId()));
		}
		return authenticatedUser;
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
	public Long getPatientIdByNationalId(String nationalId) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getPatientIdByNationalId(nationalId);
	}
	
	@Override
	public Long getPatientByNationalHealthId(String nationalHealthId) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getPatientIdByNationalHealthId(nationalHealthId);
	}
	
	@Override
	public List<CcmPatient> getAllPatientsByFirstName(String firstName) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getAllPatientsByFirstName(firstName);
	}
	
	@Override
	public List<String> getAllPatientsByNationalHealthIdFilter(String nationalHealthIdFilter) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getFilteredNationalHealthIds(nationalHealthIdFilter);
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
		
		CcmPatient ccmPatient = null;
		Date currentDate = DateUtilities.getTodaysDate(PatientAssessmentComms.DATE_TIME_CUSTOM_FORMAT);
		Long patientId = null;
		
		// check national id
		if (patientAssessment.getNationalId() != null) {
			patientId = getPatientIdByNationalId(patientAssessment.getNationalId());
		}
			
		// check national health id
		if (patientId != null && patientAssessment.getNationalHealthId() != null) {
			patientId = getPatientByNationalHealthId(patientAssessment.getNationalHealthId());
		}
		
		// if no luck finding reference, create new instance
		if (patientId == null) {
			ccmPatient = new CcmPatient(patientAssessment.getNationalId(), patientAssessment.getNationalHealthId(),
					patientAssessment.getChildFirstName(), patientAssessment.getChildSurname(),
					patientAssessment.getBirthDate(), patientAssessment.getGender(),
					patientAssessment.getCaregiverName(), patientAssessment.getRelationship(),
					patientAssessment.getPhysicalAddress(),
					patientAssessment.getVillageTa(), currentDate, currentDate);
			
			// need to persist this new ccmPatient instance to obtain a valid 'patient_id'
			CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
			patientDao.addPatient(ccmPatient);
		}
		else {
			// already exists so just need to update the 'updated' field
			ccmPatient = new CcmPatient();
			ccmPatient.setPatientId(patientId);
		}
		return ccmPatient;
	}
	
	/*******************************************************************************/
	/*********************************Visits****************************************/
	/*******************************************************************************/
	
	@Override
	@Transactional
	public PatientAssessmentResponseComms addPatientVisit(PatientAssessmentComms patientAssessment) {
		
		// 1. retrieve or create 'patient' instance
		CcmPatient ccmPatient = obtainCcmPatientReference(patientAssessment);
		
		// 2. retrieve reference to HSA user
		User hsaUser = new User();
		hsaUser.setUserId(patientAssessment.getHsaUserId());
		
		// 3. create 'patient visit' instance
		CcmPatientVisit ccmPatientVisit = new CcmPatientVisit(ccmPatient, patientAssessment.getDeviceGeneratedAssessmentId(),
				patientAssessment.getVisitDate(), hsaUser);
		
		// 4. create the 'Look' symptoms
		CcmPatientLookSymptoms ccmPatientLookSymptoms = new CcmPatientLookSymptoms(ccmPatientVisit, ccmPatient, patientAssessment.isChestIndrawing(),
							patientAssessment.getBreathsPerMinute(), patientAssessment.isSleepyUnconscious(), patientAssessment.isPalmarPallor(),
							patientAssessment.getMuacTapeColour(), patientAssessment.isSwellingBothFeet());
				
		// 5. create the 'Ask + Look' symptoms
		CcmPatientAskLookSymptoms ccmPatientAskLookSymptoms = new CcmPatientAskLookSymptoms(ccmPatientVisit, ccmPatient, patientAssessment.getProblem(), 
							patientAssessment.isCough(), patientAssessment.getCoughDuration(), patientAssessment.isDiarrhoea(),
							patientAssessment.getDiarrhoeaDuration(), patientAssessment.isBloodInStool(), patientAssessment.isFever(),
							patientAssessment.getFeverDuration(), patientAssessment.isConvulsions(), patientAssessment.isDifficultyDrinkingOrFeeding(),
							patientAssessment.isUnableToDrinkOrFeed(), patientAssessment.isVomiting(), patientAssessment.isVomitsEverything(),
							patientAssessment.isRedEye(), patientAssessment.getRedEyeDuration(), patientAssessment.isDifficultySeeing(),
							patientAssessment.getDifficultySeeingDuration(), patientAssessment.getCannotTreatProblemDetails());
		
		// associate the symptoms with the patient visit
		ccmPatientVisit.setCcmPatientLookSymptoms(ccmPatientLookSymptoms);
		ccmPatientVisit.setCcmPatientAskLookSymptoms(ccmPatientAskLookSymptoms);
				
		// 6. associate the classifications with the patient visit
		for (Map.Entry<String, String> entry : patientAssessment.getClassifications().entrySet()) {
			ccmPatientVisit.getCcmPatientClassificationList().add(new CcmPatientClassification(ccmPatientVisit, new CcmClassification(entry.getKey(), entry.getValue()), ccmPatient));
		}
		
		// 7. associate the treatments with the patient visit
		for (Map.Entry<String, String> entry : patientAssessment.getTreatments().entrySet()) {
			ccmPatientVisit.getCcmPatientTreatmentList().add(new CcmPatientTreatment(ccmPatientVisit, new CcmTreatment(entry.getKey(), entry.getValue()), ccmPatient));
		}
		
		// 8. create the 'assessment analytics' record
		CcmAssessmentAnalytics ccmAssessmentAnalytics = new CcmAssessmentAnalytics(ccmPatientVisit, patientAssessment.isBreathCounterUsed(), 
				patientAssessment.isBreathFullTimeAssessment(), patientAssessment.getLatitudeLocation(), patientAssessment.getLongitudeLocation());
		
		// associate the assessment analytics with the patient visit
		ccmPatientVisit.setCcmAssessmentAnalytics(ccmAssessmentAnalytics);
		
		// 9. add the CcmPatientVisit record to the DB
		CcmPatientVisitDao patientVisitDao = (CcmPatientVisitDao) getDaoBeans().get("CcmPatientVisitDao");
		patientVisitDao.addPatientVisit(ccmPatientVisit);
						
		// 10. construct 'communication response' for reply to device
		PatientAssessmentResponseComms assessmentResponse = new PatientAssessmentResponseComms(patientAssessment.getDeviceGeneratedAssessmentId(), 
																	ccmPatientVisit.getVisitId(), ccmPatient.getPatientId(), ccmPatient.getNationalId(), 
																	ccmPatient.getNationalHealthId(), ccmPatient.getChildFirstName(), 
																	ccmPatient.getChildSurname());
		
		return assessmentResponse;
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
	/*******************************Disease Surveillance****************************/
	/*******************************************************************************/
	@Override
	public List<SurveillanceRecord> getSurveillanceRecords(SurveillanceRequestComms surveillanceRequestComms) {	
		CcmAssessmentAnalyticsDao surveillanceDao = (CcmAssessmentAnalyticsDao) getDaoBeans().get("CcmAssessmentAnalyticsDao");
		List<SurveillanceRecord> daoSurveillanceRecords = surveillanceDao.getSurveillanceRecords(surveillanceRequestComms);
		
		// check for any duplicated coordinates and modify slightly so
		// they each are displayed on the browser map
		return modifyDuplicatedCoordinates(daoSurveillanceRecords);
	}
	
	
	/**
	 * Responsible for examining a group of surveillance records and determining whether
	 * any duplicates exist. A duplicate is identified as having the same longitude and
	 * latitude coordinate values.
	 * 
	 * Duplicate records have their coordinate values manipulated slightly by an offset.
	 * This is ensure they are assigned their own marker on the map.
	 * 
	 * @param originalRecords
	 * @return modifiedRecords
	 */
	private List<SurveillanceRecord> modifyDuplicatedCoordinates(Collection<SurveillanceRecord> originalRecords) {
		final List<SurveillanceRecord> modifiedRecords = new ArrayList<SurveillanceRecord>();

		@SuppressWarnings("serial")
		Set<SurveillanceRecord> surveillanceSet = new HashSet<SurveillanceRecord>() {
			@Override
			public boolean add(SurveillanceRecord element) {
				if (contains(element)) {
					Double latitude = Double.valueOf(element.getLatitude()) + ((Math.random()*10)/10000); // minor adjustment only
					Double longitude = Double.valueOf(element.getLongitude()) + ((Math.random()*10)/10000); // minor adjustment only
					element.setLatitude(Double.toString(latitude));
					element.setLongitude(Double.toString(longitude));
				}
				modifiedRecords.add(element);
				return super.add(element);
			}
		};

		for (SurveillanceRecord record : originalRecords) {
			surveillanceSet.add(record);
		}
		return modifiedRecords;
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
