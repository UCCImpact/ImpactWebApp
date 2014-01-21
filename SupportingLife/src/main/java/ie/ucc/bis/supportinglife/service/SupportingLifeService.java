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
	/*********************************Getters/Setters*******************************/
	/*******************************************************************************/
	public Map<String, Dao> getDaoBeans() {
		return daoBeans;
	}

	public void setDaoBeans(Map<String, Dao> daoBeans) {
		this.daoBeans = daoBeans;
	}
}
