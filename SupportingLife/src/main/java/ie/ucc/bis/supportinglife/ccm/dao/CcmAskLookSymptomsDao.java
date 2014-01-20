package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

public interface CcmAskLookSymptomsDao extends Dao {

	public CcmPatientAskLookSymptoms getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
}
