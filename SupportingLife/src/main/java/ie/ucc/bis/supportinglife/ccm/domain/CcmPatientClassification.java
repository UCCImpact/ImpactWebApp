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
 * Domain class capturing a patient's classification
 * following a patient assessment
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_patient_classification")
public class CcmPatientClassification implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -5039364796763002145L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	// association to sl_ccm_patient_visit table
	// - a patient visit can have many classifications
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="visit_id")
	private CcmPatientVisit visit;

	// association to sl_ccm_classification table
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="classification_id")
	private CcmClassification classification;
	
	// association to sl_ccm_patient table
	// - a patient can have many classifications
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private CcmPatient patient;
		
		 
	public CcmPatientClassification() {}

	/**
	 * Constructor
	 * 
	 * @param visit
	 * @param classification
	 * @param patient
	 */
	public CcmPatientClassification(CcmPatientVisit visit, CcmClassification classification, CcmPatient patient) {	
		setVisit(visit);
		setClassification(classification);
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

	public CcmClassification getClassification() {
		return classification;
	}

	public void setClassification(CcmClassification classification) {
		this.classification = classification;
	}

	public CcmPatient getPatient() {
		return patient;
	}

	public void setPatient(CcmPatient patient) {
		this.patient = patient;
	}
}
