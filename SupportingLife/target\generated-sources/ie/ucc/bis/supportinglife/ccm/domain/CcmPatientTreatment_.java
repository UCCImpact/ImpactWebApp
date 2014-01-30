package ie.ucc.bis.supportinglife.ccm.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CcmPatientTreatment.class)
public abstract class CcmPatientTreatment_ {

	public static volatile SingularAttribute<CcmPatientTreatment, Long> id;
	public static volatile SingularAttribute<CcmPatientTreatment, CcmPatient> patient;
	public static volatile SingularAttribute<CcmPatientTreatment, CcmTreatment> treatment;
	public static volatile SingularAttribute<CcmPatientTreatment, CcmPatientVisit> visit;

}

