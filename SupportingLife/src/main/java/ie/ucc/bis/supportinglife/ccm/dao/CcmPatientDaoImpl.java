package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient_;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class CcmPatientDaoImpl implements CcmPatientDao {

	private static final String WILDCARD = "%";
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CcmPatient getPatientById(long id) {
		return entityManager.find(CcmPatient.class, id);
	}

	@Override
	public Long addPatient(CcmPatient patient) {
		entityManager.persist(patient);
		// save to DB
		entityManager.flush();
		
		return patient.getPatientId();
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

	@Override
	public List<CcmPatient> getAllPatientsByNationalHealthIdFilter(String nationalHealthIdFilter) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatient> criteriaQuery = criteriaBuilder.createQuery(CcmPatient.class);
		Root<CcmPatient> ccmPatientRoot = criteriaQuery.from(CcmPatient.class);
		
		// add wildcards to national health id filter to pick up as many matches as possible
		nationalHealthIdFilter =  nationalHealthIdFilter + WILDCARD;
		
		Predicate nationalHealthIdCompareCondition = criteriaBuilder.like(ccmPatientRoot.get(CcmPatient_.nationalHealthId), nationalHealthIdFilter);
		
		criteriaQuery.where(criteriaBuilder.and(nationalHealthIdCompareCondition));
		
		List<CcmPatient> patientResults = entityManager.createQuery(criteriaQuery).getResultList();
	       
	    return patientResults;	
	}

}
