package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;

import java.util.List;

public interface CcmPatientDao extends Dao {

	// to add a new patient
	public void addPatient(CcmPatient patient);
	
	public List<CcmPatient> getAllPatients();
	public Long getPatientIdByNationalId(String nationalId);
	public Long getPatientIdByNationalHealthId(String nationalHealthId);
	public List<CcmPatient> getAllPatientsByFirstName(String firstName);
	
	public List<String> getFilteredNationalHealthIds(String nationalHealthIdFilter);
}
