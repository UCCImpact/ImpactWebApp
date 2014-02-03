package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.Date;
import java.util.List;

public interface CcmPatientVisitDao extends Dao {
	
	public CcmPatientVisit getPatientVisitbyVisitId(long visitId);
	public List<CcmPatientVisit> getPatientVisitsByPatientId(long patientId);
	public List<CcmPatientVisit> getAllPatientVisits();
	
	public List<CcmPatientVisit> getPatientVisits(String nationalId,
							String nationalHealthId, String hsaUserId, 
							Date assessmentDateFrom, Date assessmentDateTo, 
							List<CheckboxFormElement> selectedLookSymptoms,
							List<CheckboxFormElement> selectedAskLookSymptoms,
							List<CheckboxFormElement> selectedClassifications,
							List<Treatment> selectedTreatments);
}
