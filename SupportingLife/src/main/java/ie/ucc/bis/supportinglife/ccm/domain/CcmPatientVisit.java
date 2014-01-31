package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Domain class capturing a patient visit
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_patient_visit")
public class CcmPatientVisit implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -8482638730727969755L;

	@Id
	@Column(name="visit_id")
	@GeneratedValue
	private Long visitId;
	
	// association to sl_ccm_patient table
	// - one patient can have many visits 
	@ManyToOne
    @JoinColumn(name="patient_id")
    private CcmPatient patient;
		
	@Column(name="visit_dt") 
	@Temporal(TemporalType.DATE)
	private Date visitDate;
	
	// association to sl_ccm_patient_classification table
	// - a patient visit can have many classifications
	@OneToMany(cascade=CascadeType.ALL,mappedBy="visit")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<CcmPatientClassification> ccmPatientClassificationList;
	
	// association to sl_ccm_patient_treatment table
	// - a patient visit can have many treatments
	@OneToMany(cascade=CascadeType.ALL,mappedBy="visit")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<CcmPatientTreatment> ccmPatientTreatmentList;
	

	public CcmPatientVisit() {}

	/**
	 * Constructor
	 * 
	 * @param patient
	 * @param visitDate
	 */
	public CcmPatientVisit(CcmPatient patient, Date visitDate) {	
		setPatient(patient);
		setVisitDate(visitDate);
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public CcmPatient getPatient() {
		return patient;
	}

	public void setPatient(CcmPatient patient) {
		this.patient = patient;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Set<CcmPatientClassification> getCcmPatientClassificationList() {
		return ccmPatientClassificationList;
	}

	public void setCcmPatientClassificationList(
			Set<CcmPatientClassification> ccmPatientClassificationList) {
		this.ccmPatientClassificationList = ccmPatientClassificationList;
	}

	public Set<CcmPatientTreatment> getCcmPatientTreatmentList() {
		return ccmPatientTreatmentList;
	}

	public void setCcmPatientTreatmentList(
			Set<CcmPatientTreatment> ccmPatientTreatmentList) {
		this.ccmPatientTreatmentList = ccmPatientTreatmentList;
	}
}
