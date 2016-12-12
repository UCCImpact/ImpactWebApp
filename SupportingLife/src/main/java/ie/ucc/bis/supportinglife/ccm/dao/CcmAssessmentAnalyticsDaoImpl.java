package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmAssessmentAnalytics;
import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmClassification_; 
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification_;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit_;
import ie.ucc.bis.supportinglife.communication.SurveillanceRequestComms;
import ie.ucc.bis.supportinglife.surveillance.SurveillanceRecord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
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

	@Override
	public List<SurveillanceRecord> getSurveillanceRecords(SurveillanceRequestComms surveillanceRequestComms) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// Create  criteria query and pass the value object which needs to be populated as result
		CriteriaQuery<CcmPatientVisit> query = criteriaBuilder.createQuery(CcmPatientVisit.class);
		// Specify to criteria query which tables/entities you want to fetch
		Root<CcmPatientVisit> patientVisitRoot = query.from(CcmPatientVisit.class);
			
		// This list will contain all Predicates (where clauses)
		List<Predicate> criteriaList = new ArrayList<Predicate>();
		
		///////
		
		// retrieve only those records for patient visits where the date is later than the 'Surveillance Start' field
		if (surveillanceRequestComms.getStartSurveillanceDate() != null) {
			Predicate assessmentDateFromCondition = criteriaBuilder.greaterThanOrEqualTo(patientVisitRoot.get(CcmPatientVisit_.visitDate), 
														surveillanceRequestComms.getStartSurveillanceDate());
			criteriaList.add(assessmentDateFromCondition);
		}
		
		// 6. retrieve only those records for patient visits where the date is earlier than the 'Surveillance End' field
		if (surveillanceRequestComms.getEndSurveillanceDate() != null) {
			Predicate assessmentDateBeforeCondition = criteriaBuilder.lessThanOrEqualTo(patientVisitRoot.get(CcmPatientVisit_.visitDate), 
															surveillanceRequestComms.getEndSurveillanceDate());
			criteriaList.add(assessmentDateBeforeCondition);
		}
		
		////////
		
		// join the CcmPatientVisit and the CcmPatientClassification tables
		Join<CcmPatientVisit, CcmPatientClassification> ccmPatientClassificationJoin = patientVisitRoot.join(CcmPatientVisit_.ccmPatientClassificationList);
		// join the CcmPatientClassification and CcmClassification tables
		Join<CcmPatientClassification, CcmClassification> ccmClassificationJoin = ccmPatientClassificationJoin.join(CcmPatientClassification_.classification);
		
		// initially we'll pull back all records which have AT LEAST ONE of the user selected classifications
		criteriaList.add(criteriaBuilder.isTrue(ccmClassificationJoin.get(CcmClassification_.classificationKey).in(surveillanceRequestComms.getClassificationKeys())));
		
		query.distinct(true);	
		query.where(criteriaBuilder.and(criteriaList.toArray(new Predicate[0])));
				
	    List<CcmPatientVisit> patientVisitResults = entityManager.createQuery(query).getResultList();
	    
	    List<SurveillanceRecord> surveillanceRecords = new ArrayList<SurveillanceRecord>();
	    for (CcmPatientVisit patientVisit : patientVisitResults) {
	    	for (CcmPatientClassification patientClassification : patientVisit.getCcmPatientClassificationList()) {
		    	SurveillanceRecord dataRecord = new SurveillanceRecord();
		    	String classificationKey = patientClassification.getClassification().getClassificationKey();
		    	
		    	if (containsEqualsIgnoreCase(surveillanceRequestComms.getClassificationKeys(), classificationKey)) {
			    	dataRecord.setPatientId(String.valueOf(patientVisit.getPatient().getPatientId()));
			    	dataRecord.setAssessmentDate(patientVisit.getVisitDate().toString());
	
			    	dataRecord.setLatitude(patientVisit.getCcmAssessmentAnalytics().getLatitude());
			    	dataRecord.setLongitude(patientVisit.getCcmAssessmentAnalytics().getLongitude());
			    	
			    	// account for any occasion if which a GPS location was not picked up
			    	if (dataRecord.getLatitude() != null && dataRecord.getLongitude() != null) {
			    		surveillanceRecords.add(dataRecord);
			    	}
			    	// have captured this patient visit so move onto next one
			    	break;
		    	}
	    	}
	    }
	    return surveillanceRecords;
	}
	
	private boolean containsEqualsIgnoreCase(Collection<String> stringCollection, String searchString) {
		for (String elementString : stringCollection) {
			if (searchString.equalsIgnoreCase(elementString)) {
				return true;
			}
		}
		return false;
	}
}
