package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatient_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmTreatment_;
import ie.ucc.bis.supportinglife.ccm.domain.User;
import ie.ucc.bis.supportinglife.ccm.domain.User_;
import ie.ucc.bis.supportinglife.reference.AskLookSymptomsEnum;
import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.LookSymptomsEnum;
import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
	public List<CcmPatientVisit> getPatientVisitbyVisitId(long visitId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CcmPatientVisit> criteriaQuery = criteriaBuilder.createQuery(CcmPatientVisit.class);
		Root<CcmPatientVisit> root = criteriaQuery.from(CcmPatientVisit.class);
		
		criteriaQuery.select(root)
        	.where(criteriaBuilder.and(
        		criteriaBuilder.equal(root.get("visitId"), visitId)));

		List<CcmPatientVisit> patientVisitResults = new ArrayList<CcmPatientVisit>();
		patientVisitResults = entityManager.createQuery(criteriaQuery).getResultList();
	    return patientVisitResults;
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
	public List<CcmPatientVisit> getPatientVisitsQuery(String patientId,
												String nationalId,
												String nationalHealthId, 
												String hsaUserId, 
												Date assessmentDateFrom, 
												Date assessmentDateTo, 
												List<CheckboxFormElement> selectedLookSymptoms,
												List<CheckboxFormElement> selectedAskLookSymptoms,
												List<CheckboxFormElement> selectedClassifications,
												List<Treatment> selectedTreatments) {

		List<CcmPatientVisit> patientVisits = new ArrayList<CcmPatientVisit>(); 
		
		Query query = entityManager.createNamedQuery("CcmPatientVisit.findPatientVisits")
												.setParameter("patientId", patientId)
												.setParameter("nationalId", nationalId)
												.setParameter("nationalHealthId", nationalHealthId)
												.setParameter("hsaUserId", hsaUserId)
										        .setParameter("assessmentDateFrom", assessmentDateFrom, TemporalType.DATE)
										        .setParameter("assessmentDateTo", assessmentDateTo, TemporalType.DATE);
		
		for (Object obj : query.getResultList()) {
			patientVisits.add((CcmPatientVisit) obj);
		}
		return patientVisits;
	}
	
	@Override
	public List<CcmPatientVisit> getPatientVisits(String patientId,
												String nationalId,
												String nationalHealthId, 
												String hsaUserId, 
												Date assessmentDateFrom, 
												Date assessmentDateTo, 
												List<CheckboxFormElement> selectedLookSymptoms,
												List<CheckboxFormElement> selectedAskLookSymptoms,
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
		Join<CcmPatientVisit, User> ccmUserJoin = patientVisitRoot.join(CcmPatientVisit_.user); // Default is inner

		/*********************************************/
		/** Join table to handle 'Ask Look Symptoms' */
		/*********************************************/
		// join the CcmPatientVisit and the CcmPatientAskLookSymptoms tables
		Join<CcmPatientVisit, CcmPatientAskLookSymptoms> ccmPatientAskLookSymptomsJoin = patientVisitRoot.join(CcmPatientVisit_.ccmPatientAskLookSymptoms);

		/*********************************************/
		/**   Join table to handle 'Look Symptoms'   */
		/*********************************************/
		// join the CcmPatientVisit and the CcmPatientLookSymptoms tables
		Join<CcmPatientVisit, CcmPatientLookSymptoms> ccmPatientLookSymptomsJoin = patientVisitRoot.join(CcmPatientVisit_.ccmPatientLookSymptoms);
		
		/*********************************************/
		/**  Join tables to handle classifications  **/
		/*********************************************/
	    Set<String> classificationsKeysRequired = retrieveUserSpecifiedKeys(selectedClassifications);
	    // only join if there are classifications specified by the user in the criteria form
		if (classificationsKeysRequired.size() != 0) {
			// join the CcmPatientVisit and the CcmPatientClassification tables
			Join<CcmPatientVisit, CcmPatientClassification> ccmPatientClassificationJoin = patientVisitRoot.join(CcmPatientVisit_.ccmPatientClassificationList);
			// join the CcmPatientClassification and CcmClassification tables
			Join<CcmPatientClassification, CcmClassification> ccmClassificationJoin = ccmPatientClassificationJoin.join(CcmPatientClassification_.classification);
			
			// initially we'll pull back all records which have AT LEAST ONE of the user selected classifications
			criteriaList.add(builder.isTrue(ccmClassificationJoin.get(CcmClassification_.classificationKey).in(classificationsKeysRequired)));
		}

		/*********************************************/
		/**    Join tables to handle treatments     **/
		/*********************************************/
		Set<String> treatmentKeysRequired = retrieveUserSpecifiedKeys(selectedTreatments);
	    // only join if there are treatments specified by the user in the criteria form		
		if (treatmentKeysRequired.size() != 0) {
			// join the CcmPatientVisit and the CcmPatientTreatment tables
			Join<CcmPatientVisit, CcmPatientTreatment> ccmPatientTreatmentJoin = patientVisitRoot.join(CcmPatientVisit_.ccmPatientTreatmentList);
			// join the CcmPatientTreatment and CcmTreatment tables
			Join<CcmPatientTreatment, CcmTreatment> ccmTreatmentJoin = ccmPatientTreatmentJoin.join(CcmPatientTreatment_.treatment);
			
			// initially we'll pull back all records which have AT LEAST ONE of the user selected treatments
			criteriaList.add(builder.isTrue(ccmTreatmentJoin.get(CcmTreatment_.treatmentKey).in(treatmentKeysRequired)));
		}

		// retrieve patient associated with the Patient Id provided
		DaoUtils.addEqualCondition(patientId, builder, criteriaList, ccmPatientJoin, CcmPatient_.patientId);
		
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
		
		// 7. selected 'Ask Look' Symptoms
		addAskLookSymptomConditions(selectedAskLookSymptoms, builder, criteriaList, ccmPatientAskLookSymptomsJoin);

		// 8. selected 'Look' Symptoms
		addLookSymptomConditions(selectedLookSymptoms, builder, criteriaList, ccmPatientLookSymptomsJoin);
		
		// avoid duplicates in resultset
		query.distinct(true);	
		query.where(builder.and(criteriaList.toArray(new Predicate[0])));
				
	    List<CcmPatientVisit> patientVisitResults = entityManager.createQuery(query).getResultList();
	        
	    return filterPatientVisitResults(classificationsKeysRequired, treatmentKeysRequired, patientVisitResults);
	}


	/**
	 * Method to SQL conditions with respect to 'Ask Look' Symptoms depending
	 * upon user's symptom selections.
	 * 
	 *   			'ASK LOOK SYMPTOMS'	
	 *   1. COUGH							
	 *   2. DIARRHOEA							
	 *   3. BLOOD_IN_STOOL
	 *   4. FEVER			
	 *   5. CONVULSIONS							
	 *   6. DIFFICULTY_DRINKING_OR_FEEDING		
	 *   7. NOT_ABLE_TO_DRINK_OR_FEED_ANYTHING
	 *   8. VOMITING							
	 *   9. VOMITS_EVERYTHING					
	 *   10. RED_EYES								
	 *   11. DIFFICULTY_IN_SEEING
	 *   12. OTHER_PROBLEMS
	 *   
	 * @param selectedAskLookSymptoms
	 * @param builder
	 * @param criteriaList
	 * @param ccmPatientAskLookSymptomsJoin
	 * 
	 */
	private void addAskLookSymptomConditions(List<CheckboxFormElement> selectedAskLookSymptoms,
									CriteriaBuilder builder, List<Predicate> criteriaList,
									Join<CcmPatientVisit, CcmPatientAskLookSymptoms> ccmPatientAskLookSymptomsJoin) {
		
		for (CheckboxFormElement askLookSymptom : selectedAskLookSymptoms) {
			Predicate symptomCondition = null;
			
			if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.COUGH.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.cough), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.DIARRHOEA.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.diarrhoea), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.BLOOD_IN_STOOL.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.bloodInStool), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.FEVER.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.fever), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.CONVULSIONS.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.convulsions), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.DIFFICULTY_DRINKING_OR_FEEDING.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.difficultyDrinkingOrFeeding), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.NOT_ABLE_TO_DRINK_OR_FEED_ANYTHING.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.unableToDrinkOrFeed), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.VOMITING.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.vomiting), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.VOMITS_EVERYTHING.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.vomitsEverything), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.RED_EYES.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.redEye), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.DIFFICULTY_IN_SEEING.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.difficultySeeing), true);
				criteriaList.add(symptomCondition);
			}
			else if (askLookSymptom.getKey().equalsIgnoreCase(AskLookSymptomsEnum.OTHER_PROBLEMS.name())) {
				symptomCondition = builder.equal(ccmPatientAskLookSymptomsJoin.get(CcmPatientAskLookSymptoms_.otherProblems), true);
				criteriaList.add(symptomCondition);
			}
		}
	}
	
	/**
	 * Method to SQL conditions with respect to 'Look' Symptoms depending
	 * upon user's symptom selections.
	 * 
	 *   			'LOOK SYMPTOMS'	
	 *   
	 *   1. CHEST_INDRAWING												
	 *   2. SLEEPY_UNCONSCIOUS
	 *   3. PALMAR_PALLOR			
	 *   4. MUAC_TAPE							
	 *   5. FEET_SWELLING
	 *   
	 * @param selectedLookSymptoms
	 * @param builder
	 * @param criteriaList
	 * @param ccmPatientLookSymptomsJoin
	 * 
	 */
	private void addLookSymptomConditions(List<CheckboxFormElement> selectedLookSymptoms,
									CriteriaBuilder builder, List<Predicate> criteriaList,
									Join<CcmPatientVisit, CcmPatientLookSymptoms> ccmPatientLookSymptomsJoin) {
		
		for (CheckboxFormElement lookSymptom : selectedLookSymptoms) {
			Predicate symptomCondition = null;
			
			if (lookSymptom.getKey().equalsIgnoreCase(LookSymptomsEnum.CHEST_INDRAWING.name())) {
				symptomCondition = builder.equal(ccmPatientLookSymptomsJoin.get(CcmPatientLookSymptoms_.chestIndrawing), true);
				criteriaList.add(symptomCondition);
			}
			else if (lookSymptom.getKey().equalsIgnoreCase(LookSymptomsEnum.SLEEPY_UNCONSCIOUS.name())) {
				symptomCondition = builder.equal(ccmPatientLookSymptomsJoin.get(CcmPatientLookSymptoms_.sleepyUnconscious), true);
				criteriaList.add(symptomCondition);
			}
			else if (lookSymptom.getKey().equalsIgnoreCase(LookSymptomsEnum.PALMAR_PALLOR.name())) {
				symptomCondition = builder.equal(ccmPatientLookSymptomsJoin.get(CcmPatientLookSymptoms_.palmarPallor), true);
				criteriaList.add(symptomCondition);
			}
			else if (lookSymptom.getKey().equalsIgnoreCase(LookSymptomsEnum.MUAC_TAPE.name())) {
				symptomCondition = builder.equal(ccmPatientLookSymptomsJoin.get(CcmPatientLookSymptoms_.muacTapeColour), true);
				criteriaList.add(symptomCondition);
			}
			else if (lookSymptom.getKey().equalsIgnoreCase(LookSymptomsEnum.FEET_SWELLING.name())) {
				symptomCondition = builder.equal(ccmPatientLookSymptomsJoin.get(CcmPatientLookSymptoms_.swellingBothFeet), true);
				criteriaList.add(symptomCondition);
			}
		}
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
		else {
			filteredResults.add(patientVisit);
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
		else {
			filteredPatientVisitResults.add(patientVisit);
		}
	} // end of filterPatientVisitResultsByClassificationsRequired(..)	
}
