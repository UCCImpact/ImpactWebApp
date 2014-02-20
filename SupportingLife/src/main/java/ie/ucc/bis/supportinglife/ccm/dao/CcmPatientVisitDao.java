package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.Date;
import java.util.List;

public interface CcmPatientVisitDao extends Dao {
	
	public List<CcmPatientVisit> getPatientVisitbyVisitId(long visitId);
	public List<CcmPatientVisit> getPatientVisitsByPatientId(long patientId);
	public List<CcmPatientVisit> getAllPatientVisits();
	
	/**
	 * DAO Handler for performing generic CCM Custom Form Queries
	 * against DB. Uses JPA Criteria Builder.
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
	public List<CcmPatientVisit> getPatientVisits(String patientId, String nationalId,
							String nationalHealthId, String hsaUserId, 
							Date assessmentDateFrom, Date assessmentDateTo, 
							List<CheckboxFormElement> selectedLookSymptoms,
							List<CheckboxFormElement> selectedAskLookSymptoms,
							List<CheckboxFormElement> selectedClassifications,
							List<Treatment> selectedTreatments);
	

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
