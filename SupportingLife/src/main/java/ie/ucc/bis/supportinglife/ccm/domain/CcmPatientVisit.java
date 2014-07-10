package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

@NamedQueries({@NamedQuery(name="CcmPatientVisit.findPatientVisits", 
query=	"SELECT PV FROM CcmPatientVisit PV " +
		"JOIN PV.ccmPatientClassificationList CPC " +
		"WHERE (:patientId = '' OR PV.patient.patientId = :patientId) " +
		"AND (:nationalId = '' OR PV.patient.nationalId = :nationalId) " +
		"AND (:nationalHealthId = '' OR PV.patient.nationalHealthId = :nationalHealthId) " +
		"AND (:hsaUserId = '' OR PV.user.userId = :hsaUserId) " +
		"AND (PV.visitDate >= :assessmentDateFrom AND PV.visitDate <= :assessmentDateTo) "
		)})

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
	
	@Column(name="device_generated_id")
	private String deviceGeneratedId;
	
	// association to sl_ccm_patient table
	// - one patient can have many visits 
	@ManyToOne
    @JoinColumn(name="patient_id")
    private CcmPatient patient;
		
	@Column(name="visit_dt") 
	@Temporal(TemporalType.TIMESTAMP)
	private Date visitDate;
	
	// association to sl_user table
	// - one user can create many patient visits
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;
	
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
	
	// association to sl_ccm_look_symptoms table
	@OneToOne(cascade = CascadeType.ALL, mappedBy="visit")
	private CcmPatientLookSymptoms ccmPatientLookSymptoms;
	
	// association to sl_ccm_ask_look_symptoms table
	@OneToOne(cascade = CascadeType.ALL, mappedBy="visit")
	private CcmPatientAskLookSymptoms ccmPatientAskLookSymptoms;

	// association to sl_ccm_assessment_analytics table
	@OneToOne(cascade = CascadeType.ALL, mappedBy="visit")
	private CcmAssessmentAnalytics ccmAssessmentAnalytics;
	
	public CcmPatientVisit() {}

	/**
	 * Constructor
	 * 
	 * @param patient
	 * @param deviceGeneratedId 
	 * @param visitDate
	 * @param hsaUser
	 * 
	 */
	public CcmPatientVisit(CcmPatient patient, String deviceGeneratedId, Date visitDate, User hsaUser) {	
		setPatient(patient);
		setDeviceGeneratedId(deviceGeneratedId);
		setVisitDate(visitDate);
		setUser(hsaUser);
		
		// initialise the classifications associated with this patient visit
		Set<CcmPatientClassification> ccmPatientClassifications = new HashSet<CcmPatientClassification>();
		setCcmPatientClassificationList(ccmPatientClassifications);
		
		// initialise the treatments associated with this patient visit
		Set<CcmPatientTreatment> ccmPatientTreatments = new HashSet<CcmPatientTreatment>();
		setCcmPatientTreatmentList(ccmPatientTreatments);
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public String getDeviceGeneratedId() {
		return deviceGeneratedId;
	}

	public void setDeviceGeneratedId(String deviceGeneratedId) {
		this.deviceGeneratedId = deviceGeneratedId;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public CcmPatientLookSymptoms getCcmPatientLookSymptoms() {
		return ccmPatientLookSymptoms;
	}

	public void setCcmPatientLookSymptoms(CcmPatientLookSymptoms ccmPatientLookSymptoms) {
		this.ccmPatientLookSymptoms = ccmPatientLookSymptoms;
	}

	public CcmPatientAskLookSymptoms getCcmPatientAskLookSymptoms() {
		return ccmPatientAskLookSymptoms;
	}

	public void setCcmPatientAskLookSymptoms(CcmPatientAskLookSymptoms ccmPatientAskLookSymptoms) {
		this.ccmPatientAskLookSymptoms = ccmPatientAskLookSymptoms;
	}

	public CcmAssessmentAnalytics getCcmAssessmentAnalytics() {
		return ccmAssessmentAnalytics;
	}

	public void setCcmAssessmentAnalytics(
			CcmAssessmentAnalytics ccmAssessmentAnalytics) {
		this.ccmAssessmentAnalytics = ccmAssessmentAnalytics;
	}
}
