package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class CcmAskLookSymptomsDaoImpl implements CcmAskLookSymptomsDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CcmPatientAskLookSymptoms getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatientAskLookSymptoms> criteriaQuery = criteriaBuilder.createQuery(CcmPatientAskLookSymptoms.class);
		Root<CcmPatientAskLookSymptoms> root = criteriaQuery.from(CcmPatientAskLookSymptoms.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("visit"), ccmPatientVisit)));

		CcmPatientAskLookSymptoms patientAskLookSymptomsResult = entityManager.createQuery(criteriaQuery).getSingleResult();
	    return patientAskLookSymptomsResult;	
	}
}
