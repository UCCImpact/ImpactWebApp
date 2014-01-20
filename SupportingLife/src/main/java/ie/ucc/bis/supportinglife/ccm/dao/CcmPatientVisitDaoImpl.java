package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class CcmPatientVisitDaoImpl implements CcmPatientVisitDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CcmPatientVisit> getAllPatientVisits() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatientVisit> criteriaQuery = criteriaBuilder.createQuery(CcmPatientVisit.class);
		Root<CcmPatientVisit> root = criteriaQuery.from(CcmPatientVisit.class);
		
		criteriaQuery.select(root);
	    TypedQuery<CcmPatientVisit> typedQuery = entityManager.createQuery(criteriaQuery);
	    List<CcmPatientVisit> patientVisitResults = typedQuery.getResultList();
	    return patientVisitResults;
	}


	@Override
	public CcmPatientVisit getPatientVisitbyVisitId(long visitId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatientVisit> criteriaQuery = criteriaBuilder.createQuery(CcmPatientVisit.class);
		Root<CcmPatientVisit> root = criteriaQuery.from(CcmPatientVisit.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("visitId"), visitId)));

	    CcmPatientVisit patientVisitResult = entityManager.createQuery(criteriaQuery).getSingleResult();
	    return patientVisitResult;
	}


	@Override
	public List<CcmPatientVisit> getPatientVisitsByPatientId(long patientId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatientVisit> criteriaQuery = criteriaBuilder.createQuery(CcmPatientVisit.class);
		Root<CcmPatientVisit> root = criteriaQuery.from(CcmPatientVisit.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("patientId"), patientId)));
		
	    List<CcmPatientVisit> patientVisitResults = entityManager.createQuery(criteriaQuery).getResultList();
	    return patientVisitResults;
	}
}
