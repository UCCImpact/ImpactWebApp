package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Domain class capturing a patient's 'ask & look' symptoms
 * associated with a particular patient assessment visit
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_ask_look_symptoms")
public class CcmPatientAskLookSymptoms implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -3433216483860716716L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	// association to sl_ccm_patient_visit table
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="visit_id")
	private CcmPatientVisit visit;
		
	// association to sl_ccm_patient table
	// - a patient can have many assessments
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id")    
    private CcmPatient patient;
		
	@Column(name="problem")
	private String problem;
	
	@Column(name="cough", columnDefinition = "TINYINT(1)")
	private boolean cough;	
	
	@Column(name="cough_duration")
	private Integer coughDuration;

	@Column(name="diarrhoea", columnDefinition = "TINYINT(1)")
	private boolean diarrhoea;	
	
	@Column(name="diarrhoea_duration")
	private Integer diarrhoeaDuration;

	@Column(name="blood_in_stool", columnDefinition = "TINYINT(1)")
	private boolean bloodInStool;
	
	@Column(name="fever", columnDefinition = "TINYINT(1)")
	private boolean fever;

	@Column(name="fever_duration")
	private Integer feverDuration;
	
	@Column(name="convulsions", columnDefinition = "TINYINT(1)")
	private boolean convulsions;
	
	@Column(name="difficulty_drink_feed", columnDefinition = "TINYINT(1)")
	private boolean difficultyDrinkingOrFeeding;

	@Column(name="not_able_drink_feed", columnDefinition = "TINYINT(1)")
	private boolean unableToDrinkOrFeed;
	
	@Column(name="vomiting", columnDefinition = "TINYINT(1)")
	private boolean vomiting;
	
	@Column(name="vomits_everything", columnDefinition = "TINYINT(1)")
	private boolean vomitsEverything;
	
	@Column(name="red_eye", columnDefinition = "TINYINT(1)")
	private boolean redEye;

	@Column(name="red_eye_duration")
	private Integer redEyeDuration;
	
	@Column(name="difficulty_in_seeing", columnDefinition = "TINYINT(1)")
	private boolean difficultySeeing;

	@Column(name="difficulty_in_seeing_duration")
	private Integer difficultySeeingDuration;
	
	@Column(name="other_problems")
	private String otherProblems;
	
	public CcmPatientAskLookSymptoms() {}

	/**
	 * Constructor
	 * 
	 * @param visit
	 * @param patient
	 * @param problem
	 * @param cough
	 * @param coughDuration
	 * @param diarrhoea
	 * @param diarrhoeaDuration
	 * @param bloodInStool
	 * @param fever
	 * @param feverDuration
	 * @param convulsions
	 * @param difficultyDrinkingOrFeeding
	 * @param unableToDrinkOrFeed
	 * @param vomiting
	 * @param vomitsEverything
	 * @param redEye
	 * @param redEyeDuration
	 * @param difficultySeeing
	 * @param difficultySeeingDuration
	 * @param otherProblems
	 * 
	 */
	public CcmPatientAskLookSymptoms(CcmPatientVisit visit, CcmPatient patient, String problem, boolean cough,
								Integer coughDuration, boolean diarrhoea, Integer diarrhoeaDuration,
								boolean bloodInStool, boolean fever, Integer feverDuration,
								boolean convulsions, boolean difficultyDrinkingOrFeeding,
								boolean unableToDrinkOrFeed, boolean vomiting, boolean vomitsEverything,
								boolean redEye, Integer redEyeDuration, boolean difficultySeeing,
								Integer difficultySeeingDuration, String otherProblems) {	

		setVisit(visit);
		setPatient(patient);
		setProblem(problem);
		setCough(cough);
		setCoughDuration(coughDuration);
		setDiarrhoea(diarrhoea);
		setDiarrhoeaDuration(diarrhoeaDuration);
		setBloodInStool(bloodInStool);
		setFever(fever);
		setFeverDuration(feverDuration);
		setConvulsions(convulsions);
		setDifficultyDrinkingOrFeeding(difficultyDrinkingOrFeeding);
		setUnableToDrinkOrFeed(unableToDrinkOrFeed);
		setVomiting(vomiting);
		setVomitsEverything(vomitsEverything);
		setRedEye(redEye);
		setRedEyeDuration(redEyeDuration);
		setDifficultySeeing(difficultySeeing);
		setDifficultySeeingDuration(difficultySeeingDuration);
		setOtherProblems(otherProblems);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CcmPatientVisit getVisit() {
		return visit;
	}

	public void setVisit(CcmPatientVisit visit) {
		this.visit = visit;
	}

	public CcmPatient getPatient() {
		return patient;
	}

	public void setPatient(CcmPatient patient) {
		this.patient = patient;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public boolean isCough() {
		return cough;
	}

	public void setCough(boolean cough) {
		this.cough = cough;
	}

	public Integer getCoughDuration() {
		return coughDuration;
	}

	public void setCoughDuration(Integer coughDuration) {
		this.coughDuration = coughDuration;
	}

	public boolean isDiarrhoea() {
		return diarrhoea;
	}

	public void setDiarrhoea(boolean diarrhoea) {
		this.diarrhoea = diarrhoea;
	}

	public Integer getDiarrhoeaDuration() {
		return diarrhoeaDuration;
	}

	public void setDiarrhoeaDuration(Integer diarrhoeaDuration) {
		this.diarrhoeaDuration = diarrhoeaDuration;
	}

	public boolean isBloodInStool() {
		return bloodInStool;
	}

	public void setBloodInStool(boolean bloodInStool) {
		this.bloodInStool = bloodInStool;
	}

	public boolean isFever() {
		return fever;
	}

	public void setFever(boolean fever) {
		this.fever = fever;
	}

	public Integer getFeverDuration() {
		return feverDuration;
	}

	public void setFeverDuration(Integer feverDuration) {
		this.feverDuration = feverDuration;
	}

	public boolean isConvulsions() {
		return convulsions;
	}

	public void setConvulsions(boolean convulsions) {
		this.convulsions = convulsions;
	}

	public boolean isDifficultyDrinkingOrFeeding() {
		return difficultyDrinkingOrFeeding;
	}

	public void setDifficultyDrinkingOrFeeding(boolean difficultyDrinkingOrFeeding) {
		this.difficultyDrinkingOrFeeding = difficultyDrinkingOrFeeding;
	}

	public boolean isUnableToDrinkOrFeed() {
		return unableToDrinkOrFeed;
	}

	public void setUnableToDrinkOrFeed(boolean unableToDrinkOrFeed) {
		this.unableToDrinkOrFeed = unableToDrinkOrFeed;
	}

	public boolean isVomiting() {
		return vomiting;
	}

	public void setVomiting(boolean vomiting) {
		this.vomiting = vomiting;
	}

	public boolean isVomitsEverything() {
		return vomitsEverything;
	}

	public void setVomitsEverything(boolean vomitsEverything) {
		this.vomitsEverything = vomitsEverything;
	}

	public boolean isRedEye() {
		return redEye;
	}

	public void setRedEye(boolean redEye) {
		this.redEye = redEye;
	}

	public Integer getRedEyeDuration() {
		return redEyeDuration;
	}

	public void setRedEyeDuration(Integer redEyeDuration) {
		this.redEyeDuration = redEyeDuration;
	}

	public boolean isDifficultySeeing() {
		return difficultySeeing;
	}

	public void setDifficultySeeing(boolean difficultySeeing) {
		this.difficultySeeing = difficultySeeing;
	}

	public Integer getDifficultySeeingDuration() {
		return difficultySeeingDuration;
	}

	public void setDifficultySeeingDuration(Integer difficultySeeingDuration) {
		this.difficultySeeingDuration = difficultySeeingDuration;
	}

	public String getOtherProblems() {
		return otherProblems;
	}

	public void setOtherProblems(String otherProblems) {
		this.otherProblems = otherProblems;
	}

}
