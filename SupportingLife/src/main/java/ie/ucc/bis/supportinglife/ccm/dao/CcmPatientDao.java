package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;

import java.util.List;

public interface CcmPatientDao extends Dao {

	public void addPatient(CcmPatient patient);

	public CcmPatient getPatientById(long id);
	public List<CcmPatient> getAllPatients();
	public List<CcmPatient> getAllPatientsByFirstName(String firstName);
	public List<CcmPatient> getAllPatientsByNationalHealthIdFilter(String nationalHealthIdFilter);
}
