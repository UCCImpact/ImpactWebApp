package ie.ucc.bis.supportinglife.service;

import ie.ucc.bis.supportinglife.ccm.dao.CcmAskLookSymptomsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmLookSymptomsDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientClassificationDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientTreatmentDao;
import ie.ucc.bis.supportinglife.ccm.dao.CcmPatientVisitDao;
import ie.ucc.bis.supportinglife.ccm.dao.Dao;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SupportingLifeService implements SupportingLifeServiceInf {

	private Map<String, Dao> daoBeans;
	
	/*******************************************************************************/
	/***********************************Patients************************************/
	/*******************************************************************************/
	@Override
	public CcmPatient getPatientById(long id) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getPatientById(id);
	}
	
	@Override
	public List<CcmPatient> getAllPatients() {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getAllPatients();
	}
	
	@Override
	public List<CcmPatient> getAllPatientsByFirstName(String firstName) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		return patientDao.getAllPatientsByFirstName(firstName);
	}
	
	@Override
	public void addPatient(CcmPatient patient) {
		CcmPatientDao patientDao = (CcmPatientDao) getDaoBeans().get("CcmPatientDao");
		patientDao.addPatient(patient);
	}
	
	/*******************************************************************************/
	/*********************************Visits****************************************/
	/*******************************************************************************/
	@Override
	public CcmPatientVisit getPatientVisitbyVisitId(long visitId) {
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
	public List<CcmPatientVisit> getPatientVisits(String nationalId,
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
		return patientVisitDao.getPatientVisits(nationalId, nationalHealthId,
											hsaUserId, assessmentDateFrom,
											assessmentDateTo, selectedLookSymptoms,
											selectedAskLookSymptoms,
											selectedClassifications, selectedTreatments);
	}
	
	/*******************************************************************************/
	/*********************************Patient Symptoms******************************/
	/*******************************************************************************/
	@Override
	public CcmPatientLookSymptoms getLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit) {
		CcmLookSymptomsDao lookSymptomsDao = (CcmLookSymptomsDao) getDaoBeans().get("CcmLookSymptomsDao");
		return lookSymptomsDao.getLookSymptomsByVisit(ccmPatientVisit);
	}
	
	@Override
	public CcmPatientAskLookSymptoms getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit) {
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
			if (symptom.getChecked()) {
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
