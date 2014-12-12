package ie.ucc.bis.supportinglife.service;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.ccm.domain.User;
import ie.ucc.bis.supportinglife.communication.PatientAssessmentComms;
import ie.ucc.bis.supportinglife.communication.PatientAssessmentResponseComms;
import ie.ucc.bis.supportinglife.communication.PersonContactComms;
import ie.ucc.bis.supportinglife.communication.SurveillanceRequestComms;
import ie.ucc.bis.supportinglife.communication.UserAuthenticationComms;
import ie.ucc.bis.supportinglife.form.UserCreationForm;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;
import ie.ucc.bis.supportinglife.surveillance.SurveillancePeriodStats;
import ie.ucc.bis.supportinglife.surveillance.SurveillanceRecord;

import java.util.Date;
import java.util.List;

/**
 * @author timothyosullivan
 *
 */
public interface SupportingLifeServiceInf {
	
	/*******************************************************************************/
	/************************************Users**************************************/
	/*******************************************************************************/
	public User getUserByUserId(String userId);
	public Boolean registerUser(UserAuthenticationComms userDetails);
	public void createUser(UserCreationForm userDetails);
	public Boolean checkUserIdExistence(String userId);
	
	/*******************************************************************************/
	/***********************************Patients************************************/
	/*******************************************************************************/
	public List<CcmPatient> getAllPatients();
	public Long getPatientIdByNationalId(String nationalId);
	public Long getPatientByNationalHealthId(String nationalHealthId);
	public List<CcmPatient> getAllPatientsByFirstName(String firstName);
	public List<String> getAllPatientsByNationalHealthIdFilter(String nationalHealthIdFilter);
	
	/*******************************************************************************/
	/*********************************Patient Visits********************************/
	/*******************************************************************************/
	
	public PatientAssessmentResponseComms addPatientVisit(PatientAssessmentComms patientAssessment);
	public List<CcmPatientVisit> getPatientVisitbyVisitId(long visitId);
	public List<CcmPatientVisit> getPatientVisitsbyPatientId(long patientId);
	public List<CcmPatientVisit> getAllPatientVisits();

	
	/** Retrieve all patient visits which match the demographic criteria. */
	public List<CcmPatientVisit> getPatientVisits(String patientId,
												  String nationalId,
												  String nationalHealthId, 
												  String hsaUserId, 
												  Date assessmentDateFrom,
												  Date assessmentDateTo);
	
	/** Retrieve all patient visits which match the symptoms / classifications criteria. */
	public List<CcmPatientVisit> getPatientVisits(List<CheckboxFormElement> lookSymptoms,
												List<CheckboxFormElement> askLookSymptoms,
												List<CheckboxFormElement> classifications);
	
	/** Retrieve all patient visits which match the treatments criteria. */
	public List<CcmPatientVisit> getPatientVisits(List<Treatment> treatments);
		
	/*******************************************************************************/
	/*********************************Patient Symptoms******************************/
	/*******************************************************************************/
	public List<CcmPatientLookSymptoms> getLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
	public List<CcmPatientAskLookSymptoms> getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
	
	/*******************************************************************************/
	/******************************Patient Classifications**************************/
	/*******************************************************************************/
	public List<CcmPatientClassification> getPatientClassificationsByVisit(CcmPatientVisit ccmPatientVisit);
	
	/*******************************************************************************/
	/*******************************Patient Treatments******************************/
	/*******************************************************************************/	
	public List<CcmPatientTreatment> getPatientTreatmentsByVisit(CcmPatientVisit ccmPatientVisit);

	/*******************************************************************************/
	/*******************************Disease Surveillance****************************/
	/*******************************************************************************/
	public List<SurveillanceRecord> getSurveillanceRecords(SurveillanceRequestComms surveillanceRequestComms);
	public SurveillancePeriodStats performDiseaseSurveillancePeriodCheck(List<String> symptoms);
	
	/*******************************************************************************/
	/*******************************Contacts/Newsletter*****************************/
	/*******************************************************************************/	
	public void addPersonContact(PersonContactComms personContact);
	public void addNewsletterContact(String emailAddress);
}
