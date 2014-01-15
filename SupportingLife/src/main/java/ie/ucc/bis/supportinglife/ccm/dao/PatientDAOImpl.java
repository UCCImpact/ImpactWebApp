package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.Patient;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Patient getPatientById(long id) {
		return entityManager.find(Patient.class, id);
	}

	@Override
	public void addPatient(Patient patient) {
		entityManager.persist(patient);
		// save to DB
		entityManager.flush();
	}

	@Override
	public List<Patient> getAllPatientsByFirstName(String firstName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Patient> criteriaQuery = criteriaBuilder.createQuery(Patient.class);
		Root<Patient> root = criteriaQuery.from(Patient.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("firstName"), criteriaBuilder.parameter(String.class, "firstName"))));
	    TypedQuery<Patient> typedQuery = entityManager.createQuery(criteriaQuery);
	    
	    typedQuery.setParameter("firstName", firstName);
	    List<Patient> patientResults = typedQuery.getResultList();
	    return patientResults;				
	}
	
	@Override
	public List<Patient> getAllPatients() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Patient> criteriaQuery = criteriaBuilder.createQuery(Patient.class);
		Root<Patient> root = criteriaQuery.from(Patient.class);
					
		criteriaQuery.select(root);
	    TypedQuery<Patient> typedQuery = entityManager.createQuery(criteriaQuery);
	    List<Patient> patientResults = typedQuery.getResultList();		
		return patientResults;
	}

}
