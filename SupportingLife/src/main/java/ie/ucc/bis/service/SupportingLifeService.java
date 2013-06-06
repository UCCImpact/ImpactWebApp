package ie.ucc.bis.service;

import ie.ucc.bis.dao.PatientDAO;
import ie.ucc.bis.domain.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupportingLifeService implements SupportingLifeServiceInf {

	@Autowired
	@Qualifier("PatientDAOImpl")
	private PatientDAO patientDAO;
	
	@Transactional
	public Patient getPatientById(long id) {
		return getPatientDAO().getPatient(id);
	}

	public PatientDAO getPatientDAO() {
		return patientDAO;
	}

	public void setPatientDAO(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}
}
