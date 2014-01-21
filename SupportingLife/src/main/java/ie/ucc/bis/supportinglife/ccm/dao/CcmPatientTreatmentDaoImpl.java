package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class CcmPatientTreatmentDaoImpl implements CcmPatientTreatmentDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CcmPatientTreatment> getPatientTreatmentsByVisit(CcmPatientVisit ccmPatientVisit) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatientTreatment> criteriaQuery = criteriaBuilder.createQuery(CcmPatientTreatment.class);
		Root<CcmPatientTreatment> root = criteriaQuery.from(CcmPatientTreatment.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("visit"), ccmPatientVisit)));

		List<CcmPatientTreatment> patientTreatmentsResult = entityManager.createQuery(criteriaQuery).getResultList();
	    return patientTreatmentsResult;	
	}
}
