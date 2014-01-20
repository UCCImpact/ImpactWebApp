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
 * Domain class capturing a patient's 'look' symptoms
 * associated with a particular patient assessment visit
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_look_symptoms")
public class CcmPatientLookSymptoms implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -7332136747138547164L;

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
		
	@Column(name="chest_indrawing", columnDefinition = "TINYINT(1)")
	private boolean chestIndrawing;
	
	@Column(name="breaths_per_minute")
	private Integer breathsPerMinute;
	
	@Column(name="sleepy_unconscious", columnDefinition = "TINYINT(1)")
	private boolean sleepyUnconscious;	
	
	@Column(name="palmar_pallor", columnDefinition = "TINYINT(1)")
	private boolean palmarPallor;	

	@Column(name="muac_tape_colour")
	private String muacTapeColour;	
	
	@Column(name="swelling_both_feet", columnDefinition = "TINYINT(1)")
	private boolean swellingBothFeet;	
	
	public CcmPatientLookSymptoms() {}

	/**
	 * Constructor
	 * 
	 * @param visit
	 * @param patient
	 * @param chestIndrawing
	 * @param breathsPerMinute
	 * @param sleepyUnconscious
	 * @param palmarPallor
	 * @param muacTapeColour
	 * @param swellingBothFeet
	 * 
	 */
	public CcmPatientLookSymptoms(CcmPatientVisit visit, CcmPatient patient, boolean chestIndrawing,
							Integer breathsPerMinute, boolean sleepyUnconscious, boolean palmarPallor,
							String muacTapeColour, boolean swellingBothFeet) {	
		setVisit(visit);
		setPatient(patient);
		setChestIndrawing(chestIndrawing);
		setBreathsPerMinute(breathsPerMinute);
		setSleepyUnconscious(sleepyUnconscious);
		setPalmarPallor(palmarPallor);
		setMuacTapeColour(muacTapeColour);
		setSwellingBothFeet(swellingBothFeet);
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

	public boolean isChestIndrawing() {
		return chestIndrawing;
	}

	public void setChestIndrawing(boolean chestIndrawing) {
		this.chestIndrawing = chestIndrawing;
	}

	public Integer getBreathsPerMinute() {
		return breathsPerMinute;
	}

	public void setBreathsPerMinute(Integer breathsPerMinute) {
		this.breathsPerMinute = breathsPerMinute;
	}

	public boolean isSleepyUnconscious() {
		return sleepyUnconscious;
	}

	public void setSleepyUnconscious(boolean sleepyUnconscious) {
		this.sleepyUnconscious = sleepyUnconscious;
	}

	public boolean isPalmarPallor() {
		return palmarPallor;
	}

	public void setPalmarPallor(boolean palmarPallor) {
		this.palmarPallor = palmarPallor;
	}

	public String getMuacTapeColour() {
		return muacTapeColour;
	}

	public void setMuacTapeColour(String muacTapeColour) {
		this.muacTapeColour = muacTapeColour;
	}

	public boolean isSwellingBothFeet() {
		return swellingBothFeet;
	}

	public void setSwellingBothFeet(boolean swellingBothFeet) {
		this.swellingBothFeet = swellingBothFeet;
	}
}
