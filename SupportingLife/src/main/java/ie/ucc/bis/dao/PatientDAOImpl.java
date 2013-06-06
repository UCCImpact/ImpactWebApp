package ie.ucc.bis.dao;

import ie.ucc.bis.domain.Patient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component(value="PatientDAOImpl")
public class PatientDAOImpl implements PatientDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Patient getPatient(long id) {
		return entityManager.find(Patient.class, id);
	}

}
