package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmTreatment_;
import ie.ucc.bis.supportinglife.ccm.domain.User;
import ie.ucc.bis.supportinglife.ccm.domain.User_;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
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
												List<CheckboxFormElement> selectedSymptoms,	
												List<CheckboxFormElement> selectedClassifications,
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

		/*********************************************/
		/**    Join tables to handle treatments     **/
		/*********************************************/
		// join the CcmPatientVisit and the CcmPatientTreatment tables
		Join<CcmPatientVisit, CcmPatientTreatment> ccmPatientTreatmentJoin = patientVisitRoot.join(CcmPatientVisit_.ccmPatientTreatmentList);
		// join the CcmPatientTreatment and CcmTreatment tables
		Join<CcmPatientTreatment, CcmTreatment> ccmTreatmentJoin = ccmPatientTreatmentJoin.join(CcmPatientTreatment_.treatment);		
		
		
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
		
		// 7. selected Symptoms
		Session session = entityManager.unwrap(org.hibernate.Session.class);
		
//		for (CheckboxFormElement symptom : selectedSymptoms) {
//			switch (symptom.getKey()) {
//				CASE "CHEST_INDRAWING" : break;
//			}
//		}
		
			
		// 8. selected Classifications
	    Set<String> classificationsKeysRequired = retrieveUserSpecifiedKeys(selectedClassifications);
		if (classificationsKeysRequired.size() != 0) {				
			// initially we'll pull back all records which have AT LEAST ONE of the user selected classifications
			criteriaList.add(builder.isTrue(ccmClassificationJoin.get(CcmClassification_.classificationKey).in(classificationsKeysRequired)));
		}		
		
		// 9. selected treatments
	    Set<String> treatmentKeysRequired = retrieveUserSpecifiedKeys(selectedTreatments);
	    if (treatmentKeysRequired.size() != 0){
			// initially we'll pull back all records which have AT LEAST ONE of the user selected treatments
			criteriaList.add(builder.isTrue(ccmTreatmentJoin.get(CcmTreatment_.treatmentKey).in(treatmentKeysRequired)));	    	    	
	    }
		
		// avoid duplicates in resultset
		query.distinct(true);	
		query.where(builder.and(criteriaList.toArray(new Predicate[0])));
				
	    List<CcmPatientVisit> patientVisitResults = entityManager.createQuery(query).getResultList();
	        
	    return filterPatientVisitResults(classificationsKeysRequired, treatmentKeysRequired, patientVisitResults);
	}


	/**
	 * Filter the 'patient visit' results to ensure each 'patient visit' has
	 * ALL of the specified classifications and ALL of the specified treatments
	 * from the CCM Report Criteria Form
	 * 
	 * @param classificationsKeysRequired
	 * @param patientVisitResults
	 * @return
	 */
	private List<CcmPatientVisit> filterPatientVisitResults(Set<String> classificationKeysRequired,
										Set<String> treatmentKeysRequired,
										List<CcmPatientVisit> patientVisitResults) {
		List<CcmPatientVisit> classificationFilteredResults = new ArrayList<CcmPatientVisit>();
		List<CcmPatientVisit> filteredResults = new ArrayList<CcmPatientVisit>();

    	// Filter the 'patient visit' results to ensure each 'patient visit' has
   	    // ALL of the specified classifications from the CCM Report Criteria form
	    for (CcmPatientVisit patientVisit : patientVisitResults) {
    	   	filterPatientVisitResultsByClassificationsRequired(classificationFilteredResults, classificationKeysRequired, patientVisit);    	
	    }
	        
    	// Filter the 'patient visit' results to ensure each 'patient visit' has
   	    // ALL of the specified treatments from the CCM Report Criteria form
	    for (CcmPatientVisit patientVisit : classificationFilteredResults) {
    	   	filterPatientVisitResultsByTreatmentsRequired(filteredResults, treatmentKeysRequired, patientVisit);    	
	    }	    
	    
		return filteredResults;
	}

	/**
	 * Retrieve the Set of classification Keys from User Selection on
	 * CCM report form
	 * 
	 * @param selectedClassifications
	 * 
	 * @return Set<String> 
	 */
	private Set<String> retrieveUserSpecifiedKeys(List<? extends CheckboxFormElement> userSelections) {
		
		Set<String> keysRequired = new HashSet<String>();
	    for (CheckboxFormElement userSelection : userSelections) {
	    	keysRequired.add(userSelection.getKey());
	    }
		return keysRequired;
	} // end of retrieveUserSpecifiedClassificationKeys(..)

	/**
	 * Filter the 'patient visit' results to ensure each 'patient visit' has
	 * ALL of the specified treatments from the CCM Report Criteria Form
	 * 
	 * @param filteredResults
	 * @param treatmentKeysRequired
	 * @param patientVisit
	 */
	private void filterPatientVisitResultsByTreatmentsRequired(List<CcmPatientVisit> filteredResults,
									Set<String> treatmentKeysRequired, CcmPatientVisit patientVisit) {
		
		if (treatmentKeysRequired.size() != 0) {
			Set<String> patientTreatmentKeys = new HashSet<String>();	    	
			for (CcmPatientTreatment patientTreatment : patientVisit.getCcmPatientTreatmentList()) {
				patientTreatmentKeys.add(patientTreatment.getTreatment().getTreatmentKey());
			}
						
			if (patientTreatmentKeys.containsAll(treatmentKeysRequired)) {
				filteredResults.add(patientVisit);
			}
		}
	}
	
	/**
	 * Filter the 'patient visit' results to ensure each 'patient visit' has
	 * ALL of the specified classifications from the CCM Report Criteria Form
	 * 
	 * @param filteredPatientVisitResults
	 * @param classificationsKeysRequired
	 * @param patientVisit
	 */
	private void filterPatientVisitResultsByClassificationsRequired(List<CcmPatientVisit> filteredPatientVisitResults,
												Set<String> classificationsKeysRequired, CcmPatientVisit patientVisit) {
		
		if (classificationsKeysRequired.size() != 0) {
			Set<String> patientClassificationKeys = new HashSet<String>();	    	
			for (CcmPatientClassification patientClassification : patientVisit.getCcmPatientClassificationList()) {
				patientClassificationKeys.add(patientClassification.getClassification().getClassificationKey());
			}
						
			if (patientClassificationKeys.containsAll(classificationsKeysRequired)) {
				filteredPatientVisitResults.add(patientVisit);
			}
		}
	} // end of filterPatientVisitResultsByClassificationsRequired(..)	
}
