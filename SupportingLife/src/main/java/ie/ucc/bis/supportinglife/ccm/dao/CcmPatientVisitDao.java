package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;
import ie.ucc.bis.supportinglife.surveillance.SurveillancePeriodStats;

import java.util.Date;
import java.util.List;

public interface CcmPatientVisitDao extends Dao {
	
	public void addPatientVisit(CcmPatientVisit patientVisit);
	
	public List<CcmPatientVisit> getPatientVisitbyVisitId(long visitId);
	public List<CcmPatientVisit> getPatientVisitsByPatientId(long patientId);
	public List<CcmPatientVisit> getAllPatientVisits();
	
	/**
	 * DAO Handler for performing generic CCM Custom Form Queries
	 * against DB using demographic criteria. 
	 */
	public List<CcmPatientVisit> getPatientVisits(String patientId, String nationalId,
												  String nationalHealthId, String hsaUserId, 
												  Date assessmentDateFrom, Date assessmentDateTo);
	
	/**
	 * DAO Handler for performing generic CCM Custom Form Queries
	 * against DB using symptom / classification criteria. 
	 */
	public List<CcmPatientVisit> getPatientVisits(List<CheckboxFormElement> selectedLookSymptoms,
			  									  List<CheckboxFormElement> selectedAskLookSymptoms,
			  									  List<CheckboxFormElement> selectedClassifications);
	
	/**
	 * DAO Handler for performing generic CCM Custom Form Queries
	 * against DB using treatments criteria. 
	 */
	public List<CcmPatientVisit> getPatientVisits(List<Treatment> selectedTreatments);

	/**
	 * DAO Handler for capturing number of disease classifications over a certain number of
	 * time periods i.e.
	 * 
	 * - 24 hour period
	 * - 7 days
	 * - 30 days
	 */
	public SurveillancePeriodStats performDiseaseSurveillancePeriodCheck(List<String> symptoms);
	
	/**
	 * Example method highlighting JPQL for Querying DB	
	 * 
	 * @param patientId
	 * @param nationalId
	 * @param nationalHealthId
	 * @param hsaUserId
	 * @param assessmentDateFrom
	 * @param assessmentDateTo
	 * @param selectedLookSymptoms
	 * @param selectedAskLookSymptoms
	 * @param selectedClassifications
	 * @param selectedTreatments
	 * @return
	 */
	public List<CcmPatientVisit> getPatientVisitsQuery(String patientId,
			String nationalId,
			String nationalHealthId, 
			String hsaUserId, 
			Date assessmentDateFrom, 
			Date assessmentDateTo, 
			List<CheckboxFormElement> selectedLookSymptoms,
			List<CheckboxFormElement> selectedAskLookSymptoms,
			List<CheckboxFormElement> selectedClassifications,
			List<Treatment> selectedTreatments);
}
