package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmAssessmentAnalytics;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;
import ie.ucc.bis.supportinglife.surveillance.SurveillanceRecord;

import java.util.List;

public interface CcmAssessmentAnalyticsDao extends Dao {

	public List<CcmAssessmentAnalytics> getAssessmentAnalyticsByVisit(CcmPatientVisit ccmPatientVisit);
	
	public List<SurveillanceRecord> getSurveillanceRecords();
}
