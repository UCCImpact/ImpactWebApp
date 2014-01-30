package ie.ucc.bis.supportinglife.ccm.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CcmPatientLookSymptoms.class)
public abstract class CcmPatientLookSymptoms_ {

	public static volatile SingularAttribute<CcmPatientLookSymptoms, Boolean> palmarPallor;
	public static volatile SingularAttribute<CcmPatientLookSymptoms, Long> id;
	public static volatile SingularAttribute<CcmPatientLookSymptoms, Boolean> chestIndrawing;
	public static volatile SingularAttribute<CcmPatientLookSymptoms, CcmPatient> patient;
	public static volatile SingularAttribute<CcmPatientLookSymptoms, Boolean> swellingBothFeet;
	public static volatile SingularAttribute<CcmPatientLookSymptoms, CcmPatientVisit> visit;
	public static volatile SingularAttribute<CcmPatientLookSymptoms, String> muacTapeColour;
	public static volatile SingularAttribute<CcmPatientLookSymptoms, Integer> breathsPerMinute;
	public static volatile SingularAttribute<CcmPatientLookSymptoms, Boolean> sleepyUnconscious;

}

