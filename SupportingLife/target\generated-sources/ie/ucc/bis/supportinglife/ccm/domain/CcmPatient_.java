package ie.ucc.bis.supportinglife.ccm.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CcmPatient.class)
public abstract class CcmPatient_ {

	public static volatile SingularAttribute<CcmPatient, String> childSurname;
	public static volatile SingularAttribute<CcmPatient, String> nationalId;
	public static volatile SingularAttribute<CcmPatient, Date> updatedDate;
	public static volatile SetAttribute<CcmPatient, CcmPatientClassification> ccmPatientClassificationList;
	public static volatile SingularAttribute<CcmPatient, String> nationalHealthId;
	public static volatile SingularAttribute<CcmPatient, String> villageTa;
	public static volatile SingularAttribute<CcmPatient, String> relationship;
	public static volatile SingularAttribute<CcmPatient, Long> patientId;
	public static volatile SingularAttribute<CcmPatient, String> otherRelationship;
	public static volatile SetAttribute<CcmPatient, CcmPatientTreatment> ccmPatientTreatmentList;
	public static volatile SetAttribute<CcmPatient, CcmPatientVisit> ccmPatientVisitList;
	public static volatile SingularAttribute<CcmPatient, String> caregiverName;
	public static volatile SetAttribute<CcmPatient, CcmPatientLookSymptoms> ccmPatientLookSymptomsList;
	public static volatile SingularAttribute<CcmPatient, String> childFirstName;
	public static volatile SingularAttribute<CcmPatient, String> gender;
	public static volatile SingularAttribute<CcmPatient, String> physicalAddress;
	public static volatile SingularAttribute<CcmPatient, Date> birthDate;
	public static volatile SingularAttribute<CcmPatient, User> user;
	public static volatile SingularAttribute<CcmPatient, Date> createdDate;
	public static volatile SetAttribute<CcmPatient, CcmPatientAskLookSymptoms> ccmPatientAskLookSymptomsList;

}

