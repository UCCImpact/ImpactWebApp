package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class CcmPatientDaoImpl implements CcmPatientDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CcmPatient getPatientById(long id) {
		return entityManager.find(CcmPatient.class, id);
	}

	@Override
	public void addPatient(CcmPatient patient) {
		entityManager.persist(patient);
		// save to DB
		entityManager.flush();
	}

	@Override
	public List<CcmPatient> getAllPatientsByFirstName(String childFirstName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatient> criteriaQuery = criteriaBuilder.createQuery(CcmPatient.class);
		Root<CcmPatient> root = criteriaQuery.from(CcmPatient.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("childFirstName"), childFirstName)));
		List<CcmPatient> patientResults = entityManager.createQuery(criteriaQuery).getResultList();
	    
	    return patientResults;				
	}
	
	@Override
	public List<CcmPatient> getAllPatients() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatient> criteriaQuery = criteriaBuilder.createQuery(CcmPatient.class);
		Root<CcmPatient> root = criteriaQuery.from(CcmPatient.class);
					
		criteriaQuery.select(root);
	    TypedQuery<CcmPatient> typedQuery = entityManager.createQuery(criteriaQuery);
	    List<CcmPatient> patientResults = typedQuery.getResultList();		
		return patientResults;
	}

}
