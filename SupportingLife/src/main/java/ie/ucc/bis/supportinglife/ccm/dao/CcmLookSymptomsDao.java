package ie.ucc.bis.supportinglife.ccm.dao;

import java.util.List;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

public interface CcmLookSymptomsDao extends Dao {

	public List<CcmPatientLookSymptoms> getLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
}
