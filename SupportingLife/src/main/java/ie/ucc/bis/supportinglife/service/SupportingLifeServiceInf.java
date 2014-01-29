package ie.ucc.bis.supportinglife.service;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.reference.Classification;
import ie.ucc.bis.supportinglife.reference.Symptom;
import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.Date;
import java.util.List;

/**
 * @author timothyosullivan
 *
 */
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

	/**
	 * Retrieve all patient visits which match the passed-in criteria.
	 * Used in the CCM Custom Report Form on the desktop admin site.
	 * 
	 * @param nationalId
	 * @param nationalHealthId
	 * @param hsaUserId
	 * @param assessmentDateFrom
	 * @param assessmentDateTo
	 * @param symptoms
	 * @param classifications
	 * @param treatments
	 * 
	 * @return List<CcmPatientVisit>
	 *
	 */

	public List<CcmPatientVisit> getPatientVisits(String nationalId,
												String nationalHealthId,
												String hsaUserId, 
												Date assessmentDateFrom,
												Date assessmentDateTo, 
												List<Symptom> symptoms,
												List<Classification> classifications, 
												List<Treatment> treatments);
	
	
	/*******************************************************************************/
	/*********************************Patient Symptoms******************************/
	/*******************************************************************************/
	public CcmPatientLookSymptoms getLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
	public CcmPatientAskLookSymptoms getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
	
	/*******************************************************************************/
	/******************************Patient Classifications**************************/
	/*******************************************************************************/
	public List<CcmPatientClassification> getPatientClassificationsByVisit(CcmPatientVisit ccmPatientVisit);
	
	/*******************************************************************************/
	/*******************************Patient Treatments******************************/
	/*******************************************************************************/	
	public List<CcmPatientTreatment> getPatientTreatmentsByVisit(CcmPatientVisit ccmPatientVisit);
}
