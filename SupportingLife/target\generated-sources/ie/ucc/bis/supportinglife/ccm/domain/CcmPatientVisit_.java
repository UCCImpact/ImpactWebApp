package ie.ucc.bis.supportinglife.ccm.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CcmPatientVisit.class)
public abstract class CcmPatientVisit_ {

	public static volatile SingularAttribute<CcmPatientVisit, CcmPatient> patient;
	public static volatile SetAttribute<CcmPatientVisit, CcmPatientTreatment> ccmPatientTreatmentList;
	public static volatile SetAttribute<CcmPatientVisit, CcmPatientClassification> ccmPatientClassificationList;
	public static volatile SingularAttribute<CcmPatientVisit, Long> visitId;
	public static volatile SingularAttribute<CcmPatientVisit, Date> visitDate;

}

