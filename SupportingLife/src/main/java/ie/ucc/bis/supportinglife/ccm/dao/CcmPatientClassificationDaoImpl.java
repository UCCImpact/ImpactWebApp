package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class CcmPatientClassificationDaoImpl implements CcmPatientClassificationDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CcmPatientClassification> getPatientClassificationsByVisit(CcmPatientVisit ccmPatientVisit) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatientClassification> criteriaQuery = criteriaBuilder.createQuery(CcmPatientClassification.class);
		Root<CcmPatientClassification> root = criteriaQuery.from(CcmPatientClassification.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("visit"), ccmPatientVisit)));

		List<CcmPatientClassification> patientClassificationsResult = entityManager.createQuery(criteriaQuery).getResultList();
	    return patientClassificationsResult;	
	}
}
