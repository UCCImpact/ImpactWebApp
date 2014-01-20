package ie.ucc.bis.supportinglife.service;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import java.util.List;

public interface SupportingLifeServiceInf {

	/*******************************************************************************/
	/***********************************Patients************************************/
	/*******************************************************************************/
	public void addPatient(CcmPatient patient);
	public CcmPatient getPatientById(long id);
	public List<CcmPatient> getAllPatients();
	public List<CcmPatient> getAllPatientsByFirstName(String firstName);
	
	/*******************************************************************************/
	/*********************************Patient Visits********************************/
	/*******************************************************************************/
	public CcmPatientVisit getPatientVisitbyVisitId(long visitId);
	public List<CcmPatientVisit> getPatientVisitsbyPatientId(long patientId);
	public List<CcmPatientVisit> getAllPatientVisits();

	/*******************************************************************************/
	/*********************************Patient Symptoms******************************/
	/*******************************************************************************/
	public CcmPatientLookSymptoms getLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
	public CcmPatientAskLookSymptoms getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
	
	/*******************************************************************************/
	/******************************Patient Classifications**************************/
	/*******************************************************************************/
	public List<CcmPatientClassification> getPatientClassificationsByVisit(CcmPatientVisit ccmPatientVisit);
}
