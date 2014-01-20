package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import java.util.List;

public interface CcmPatientVisitDao extends Dao {
	
	public CcmPatientVisit getPatientVisitbyVisitId(long visitId);
	public List<CcmPatientVisit> getPatientVisitsByPatientId(long patientId);
	public List<CcmPatientVisit> getAllPatientVisits();
}
