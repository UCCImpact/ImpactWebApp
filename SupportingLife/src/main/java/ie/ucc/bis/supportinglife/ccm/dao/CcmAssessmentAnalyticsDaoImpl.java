package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmAssessmentAnalytics;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class CcmAssessmentAnalyticsDaoImpl implements CcmAssessmentAnalyticsDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CcmAssessmentAnalytics> getAssessmentAnalyticsByVisit(CcmPatientVisit ccmPatientVisit) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmAssessmentAnalytics> criteriaQuery = criteriaBuilder.createQuery(CcmAssessmentAnalytics.class);
		Root<CcmAssessmentAnalytics> root = criteriaQuery.from(CcmAssessmentAnalytics.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("visit"), ccmPatientVisit)));

		List<CcmAssessmentAnalytics> assessmentAnalyticsResults = new ArrayList<CcmAssessmentAnalytics>();
		assessmentAnalyticsResults = entityManager.createQuery(criteriaQuery).getResultList();
	    return assessmentAnalyticsResults;	
	}
}
