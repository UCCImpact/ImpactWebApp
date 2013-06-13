package ie.ucc.bis.service;

import java.util.List;

import ie.ucc.bis.dao.PatientDAO;
import ie.ucc.bis.domain.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SupportingLifeService implements SupportingLifeServiceInf {

	@Autowired
	@Qualifier("PatientDAOImpl")
	private PatientDAO patientDAO;
	
	@Override
	public Patient getPatientById(long id) {
		return getPatientDAO().getPatientById(id);
	}
	
	@Override
	public void addPatient(Patient patient) {
		getPatientDAO().addPatient(patient);
	}
	
	@Override
	public List<Patient> getAllPatients() {
		return getPatientDAO().getAllPatients();
	}
	
	@Override
	public List<Patient> getAllPatientsByFirstName(String firstName) {
		return getPatientDAO().getAllPatientsByFirstName(firstName);
	}

	public PatientDAO getPatientDAO() {
		return patientDAO;
	}

	public void setPatientDAO(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}
}
