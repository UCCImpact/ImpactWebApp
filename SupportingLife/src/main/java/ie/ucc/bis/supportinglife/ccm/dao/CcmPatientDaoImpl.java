package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient_;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
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
	public void addPatient(CcmPatient patient) {		
		entityManager.persist(patient);
		// save to DB
		entityManager.flush();
		entityManager.clear();
	}
	
	@Override
	public Long getPatientIdByNationalId(String nationalId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<CcmPatient> root = criteriaQuery.from(CcmPatient.class);

		criteriaQuery.multiselect(root.get(CcmPatient_.patientId))
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get(CcmPatient_.nationalId), nationalId)));

		List<Tuple> resultSet = entityManager.createQuery(criteriaQuery).getResultList();
	   	
		if (resultSet.size() != 0) {	
			return (Long) resultSet.get(0).get(0);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public Long getPatientIdByNationalHealthId(String nationalHealthId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<CcmPatient> root = criteriaQuery.from(CcmPatient.class);

		criteriaQuery.multiselect(root.get(CcmPatient_.patientId))
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get(CcmPatient_.nationalHealthId), nationalHealthId)));

		List<Tuple> resultSet = entityManager.createQuery(criteriaQuery).getResultList();
	   	
		if (resultSet.size() != 0) {	
			return (Long) resultSet.get(0).get(0);
		}
		else
		{
			return null;
		}		
	}
	
	@Override
	public List<CcmPatient> getAllPatientsByFirstName(String childFirstName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatient> criteriaQuery = criteriaBuilder.createQuery(CcmPatient.class);
		Root<CcmPatient> root = criteriaQuery.from(CcmPatient.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get(CcmPatient_.childFirstName), childFirstName)));
		
		List<CcmPatient> patientResults = new ArrayList<CcmPatient>();
		patientResults = entityManager.createQuery(criteriaQuery).getResultList();
	    
	    return patientResults;				
	}
	
	@Override
	public List<CcmPatient> getAllPatients() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatient> criteriaQuery = criteriaBuilder.createQuery(CcmPatient.class);
		Root<CcmPatient> root = criteriaQuery.from(CcmPatient.class);
					
		criteriaQuery.select(root);
	    TypedQuery<CcmPatient> typedQuery = entityManager.createQuery(criteriaQuery);
	    
	    List<CcmPatient> patientResults = new ArrayList<CcmPatient>();
	    patientResults = typedQuery.getResultList();		
		return patientResults;
	}

	@Override
	public List<String> getFilteredNationalHealthIds(String nationalHealthIdFilter) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<CcmPatient> root = criteriaQuery.from(CcmPatient.class);
		
		criteriaQuery.multiselect(root.get(CcmPatient_.nationalHealthId));
		
		// add wildcards to national health id filter to pick up as many matches as possible
		nationalHealthIdFilter =  nationalHealthIdFilter + WILDCARD;
		Predicate nationalHealthIdCompareCondition = criteriaBuilder.like(root.get(CcmPatient_.nationalHealthId), nationalHealthIdFilter);
		criteriaQuery.where(criteriaBuilder.and(nationalHealthIdCompareCondition));

		List<Tuple> resultSet = entityManager.createQuery(criteriaQuery).getResultList();
		
		List<String> nationalHealthIds = new ArrayList<String>();
		
		for (Tuple tupleResult : resultSet) {
			nationalHealthIds.add((String)tupleResult.get(0));
		}
		
		return nationalHealthIds;
	}
}
