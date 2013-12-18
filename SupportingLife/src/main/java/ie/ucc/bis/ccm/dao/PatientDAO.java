package ie.ucc.bis.ccm.dao;

import java.util.List;

import ie.ucc.bis.ccm.domain.Patient;

public interface PatientDAO {

	public Patient getPatientById(long id);
	public void addPatient(Patient patient);
	public List<Patient> getAllPatients();
	List<Patient> getAllPatientsByFirstName(String firstName);
	
}
