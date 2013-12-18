package ie.ucc.bis.service;

import java.util.List;

import ie.ucc.bis.ccm.domain.Patient;

public interface SupportingLifeServiceInf {

	public Patient getPatientById(long id);
	public void addPatient(Patient patient);
	public List<Patient> getAllPatients();
	public List<Patient> getAllPatientsByFirstName(String firstName);
}
