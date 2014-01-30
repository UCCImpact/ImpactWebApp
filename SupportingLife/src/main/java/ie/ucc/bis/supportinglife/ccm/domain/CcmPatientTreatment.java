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
 * Domain class capturing a patient's treatments
 * following a patient assessment
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_patient_treatment")
public class CcmPatientTreatment implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -5552686356373627715L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	// association to sl_ccm_patient_visit table
	// - a patient visit can have many treatments
	@ManyToOne
	@JoinColumn(name="visit_id")
	private CcmPatientVisit visit;

	// association to sl_ccm_treatment table
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="treatment_id")
	private CcmTreatment treatment;
	
	// association to sl_ccm_patient table
	// - a patient can have many treatment assessments
	@ManyToOne
    @JoinColumn(name="patient_id")
    private CcmPatient patient;
		
		 
	public CcmPatientTreatment() {}

	/**
	 * Constructor
	 * 
	 * @param visit
	 * @param treatment
	 * @param patient
	 */
	public CcmPatientTreatment(CcmPatientVisit visit, CcmTreatment treatment, CcmPatient patient) {	
		setVisit(visit);
		setTreatment(treatment);
		setPatient(patient);
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

	public CcmTreatment getTreatment() {
		return treatment;
	}

	public void setTreatment(CcmTreatment treatment) {
		this.treatment = treatment;
	}

	public CcmPatient getPatient() {
		return patient;
	}

	public void setPatient(CcmPatient patient) {
		this.patient = patient;
	}
}
