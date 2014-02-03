package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient_;
import ie.ucc.bis.supportinglife.ccm.domain.User;
import ie.ucc.bis.supportinglife.ccm.domain.User_;
import ie.ucc.bis.supportinglife.reference.Classification;
import ie.ucc.bis.supportinglife.reference.Symptom;
import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
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
	
	@Override
	public List<CcmPatientVisit> getPatientVisits(String nationalId,
												String nationalHealthId, 
												String hsaUserId, 
												Date assessmentDateFrom, 
												Date assessmentDateTo, 
												List<Symptom> selectedSymptoms,	
												List<Classification> selectedClassifications,
												List<Treatment> selectedTreatments) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		// Create criteria query and pass the value object which needs to be populated as result
		CriteriaQuery<CcmPatientVisit> query = builder.createQuery(CcmPatientVisit.class);
		
		// Specify to criteria query which tables/entities you want to fetch
		Root<CcmPatientVisit> patientVisitRoot = query.from(CcmPatientVisit.class);
		
		// This list will contain all Predicates (where clauses)
		List<Predicate> criteriaList = new ArrayList<Predicate>();

		/*********************************************/
		/**  Join CcmPatientVisit and CcmPatient    **/
		/*********************************************/
		Join<CcmPatientVisit, CcmPatient> ccmPatientJoin = patientVisitRoot.join(CcmPatientVisit_.patient); // Default is inner

		/*********************************************/
		/**  Join CcmPatient and User tables	    **/
		/*********************************************/
		Join<CcmPatient, User> ccmUserJoin = ccmPatientJoin.join(CcmPatient_.user); // Default is inner
		
		/*********************************************/
		/**  Join tables to handle classifications  **/
		/*********************************************/
		// join the CcmPatientVisit and the CcmPatientClassification tables
		Join<CcmPatientVisit, CcmPatientClassification> ccmPatientClassificationJoin = patientVisitRoot.join(CcmPatientVisit_.ccmPatientClassificationList);
		// join the CcmPatientClassification and CcmClassification tables
		Join<CcmPatientClassification, CcmClassification> ccmClassificationJoin = ccmPatientClassificationJoin.join(CcmPatientClassification_.classification);
		
		// retrieve patient associated with the National Id provided
		DaoUtils.addEqualCondition(nationalId, builder, criteriaList, ccmPatientJoin, CcmPatient_.nationalId);

		// retrieve patient associated with the National Health Id provided
		DaoUtils.addEqualCondition(nationalHealthId, builder, criteriaList, ccmPatientJoin, CcmPatient_.nationalHealthId);
		
		// 4. retrieve patient associated with the HSA User Id provided
		DaoUtils.addEqualCondition(hsaUserId, builder, criteriaList, ccmUserJoin, User_.userId);
		
		// 5. retrieve only those records where the patient assessment date is later than the 'Assessment Date From' field
		if (assessmentDateFrom != null) {
			Predicate assessmentDateFromCondition = builder.greaterThanOrEqualTo(patientVisitRoot.get(CcmPatientVisit_.visitDate), assessmentDateFrom);
			criteriaList.add(assessmentDateFromCondition);
		}
		
		// 6. retrieve only those records where the patient assessment date is earlier than the 'Assessment Date To' field
		if (assessmentDateTo != null) {
			Predicate assessmentDateBeforeCondition = builder.lessThanOrEqualTo(patientVisitRoot.get(CcmPatientVisit_.visitDate), assessmentDateTo);
			criteriaList.add(assessmentDateBeforeCondition);
		}
		
		// 7. selectedClassifications
		if (selectedClassifications != null) {		
			List<String> classificationKeys = new ArrayList<String>();
			for (Classification selectedClassification : selectedClassifications) {
				classificationKeys.add(selectedClassification.getKey());
			}
	
	

			criteriaList.add(builder.isTrue(ccmClassificationJoin.get(CcmClassification_.classificationKey).in(classificationKeys)));
			
			// avoid duplicates in resultset
			CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
			Root<CcmPatientVisit> classification = countQuery.from(CcmPatientVisit.class);
			countQuery.where(builder.and(criteriaList.toArray(new Predicate[0])));
			countQuery.select(builder.count(classification.get(CcmPatientVisit_.visitId)));
			countQuery.having(builder.equal(builder.count(classification.get(CcmPatientVisit_.visitId)), selectedClassifications.size()));

			
		    Long count = entityManager.createQuery(countQuery).getSingleResult();
		    
		    if (count == 0)
		    {
		    	return null;
		    }
	
		//	criteriaList.add(builder.isTrue(ccmClassificationJoin.get(CcmClassification_.classificationKey).in(classificationKeys)));
		}		
		
		// avoid duplicates in resultset
//		query.distinct(true);

//		query.having(builder.equal(builder.count(ccmPatientJoin), selectedClassifications.size()));
		
		query.where(builder.and(criteriaList.toArray(new Predicate[0])));
				
	    List<CcmPatientVisit> patientVisitResults = entityManager.createQuery(query).getResultList();
	    
	    return patientVisitResults;
	}
}
