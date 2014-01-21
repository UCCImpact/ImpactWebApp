package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientTreatment;
import ie.ucc.bis.supportinglife.ccm.domain.CcmPatientVisit;

import java.util.List;

public interface CcmPatientTreatmentDao extends Dao {

	public List<CcmPatientTreatment> getPatientTreatmentsByVisit(CcmPatientVisit ccmPatientVisit);
}
