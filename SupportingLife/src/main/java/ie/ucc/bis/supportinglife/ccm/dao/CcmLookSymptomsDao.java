package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

public interface CcmLookSymptomsDao extends Dao {

	public CcmPatientLookSymptoms getLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
}
