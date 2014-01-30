package ie.ucc.bis.supportinglife.ccm.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CcmPatientClassification.class)
public abstract class CcmPatientClassification_ {

	public static volatile SingularAttribute<CcmPatientClassification, Long> id;
	public static volatile SingularAttribute<CcmPatientClassification, CcmPatient> patient;
	public static volatile SingularAttribute<CcmPatientClassification, CcmClassification> classification;
	public static volatile SingularAttribute<CcmPatientClassification, CcmPatientVisit> visit;

}

