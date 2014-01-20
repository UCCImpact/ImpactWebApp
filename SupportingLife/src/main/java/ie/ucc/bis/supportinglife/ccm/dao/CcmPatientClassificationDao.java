package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientClassification;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import java.util.List;

public interface CcmPatientClassificationDao extends Dao {

	public List<CcmPatientClassification> getPatientClassificationsByVisit(CcmPatientVisit ccmPatientVisit);
}
