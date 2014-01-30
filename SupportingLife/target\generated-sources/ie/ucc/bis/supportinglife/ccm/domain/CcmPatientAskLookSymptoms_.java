package ie.ucc.bis.supportinglife.ccm.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CcmPatientAskLookSymptoms.class)
public abstract class CcmPatientAskLookSymptoms_ {

	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Integer> diarrhoeaDuration;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Integer> feverDuration;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> redEye;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> diarrhoea;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, CcmPatientVisit> visit;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, String> problem;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> fever;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Long> id;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> cough;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> vomitsEverything;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> vomiting;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> bloodInStool;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, CcmPatient> patient;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Integer> redEyeDuration;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Integer> coughDuration;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> difficultySeeing;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> convulsions;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> difficultyDrinkingOrFeeding;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Integer> difficultySeeingDuration;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, Boolean> unableToDrinkOrFeed;
	public static volatile SingularAttribute<CcmPatientAskLookSymptoms, String> otherProblems;

}

