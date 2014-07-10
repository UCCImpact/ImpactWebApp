package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Domain class capturing any analytic data specific 
 * to a patient assessment
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_assessment_analytics")
public class CcmAssessmentAnalytics implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = 8557256411953928819L;


	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	// association to sl_ccm_patient_visit table
	// - a patient visit will have an associated analytics record
	@OneToOne
	@JoinColumn(name="visit_id")
	private CcmPatientVisit visit;

	// was breath counter used in determining breath count of patient
	@Column(name="breath_counter_used", columnDefinition = "TINYINT(1)")
	private boolean breathCounterUsed;
	
	// was a full timer assessment (i.e. 60 seconds) applied when using breath counter
	@Column(name="breath_full_time_assessment", columnDefinition = "TINYINT(1)")
	private boolean breathFullTimeAssessment;
		 
	public CcmAssessmentAnalytics() {}

	/**
	 * Constructor
	 * 
	 * @param visit
	 * @param breathCounterUsed
	 * @param breathFullTimeAssessment
	 * 
	 */
	public CcmAssessmentAnalytics(CcmPatientVisit visit, boolean breathCounterUsed, boolean breathFullTimeAssessment) {	
		setVisit(visit);
		setBreathCounterUsed(breathCounterUsed);
		setBreathFullTimeAssessment(breathFullTimeAssessment);
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

	public boolean isBreathCounterUsed() {
		return breathCounterUsed;
	}

	public void setBreathCounterUsed(boolean breathCounterUsed) {
		this.breathCounterUsed = breathCounterUsed;
	}

	public boolean isBreathFullTimeAssessment() {
		return breathFullTimeAssessment;
	}

	public void setBreathFullTimeAssessment(boolean breathFullTimeAssessment) {
		this.breathFullTimeAssessment = breathFullTimeAssessment;
	}
}
