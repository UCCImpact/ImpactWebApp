package ie.ucc.bis.supportinglife.ccm.dao;

import java.util.List;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientAskLookSymptoms;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

public interface CcmAskLookSymptomsDao extends Dao {

	public List<CcmPatientAskLookSymptoms> getAskLookSymptomsByVisit(CcmPatientVisit ccmPatientVisit);
}
