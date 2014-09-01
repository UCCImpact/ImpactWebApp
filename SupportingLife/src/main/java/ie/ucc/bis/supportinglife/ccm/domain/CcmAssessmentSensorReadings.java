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
 * Domain class capturing any sensor vital sign
 * readings related to a patient assessment
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_assessment_sensor")
public class CcmAssessmentSensorReadings implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -6686515869582714195L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	// association to sl_ccm_patient_visit table
	// - a patient visit will have an associated 'sensor readings' record
	@OneToOne
	@JoinColumn(name="visit_id")
	private CcmPatientVisit visit;
	
	@Column(name="heart_rate")
	private String heartRate;
	
	@Column(name="respiratory_rate")
	private String respiratoryRate;
	
	@Column(name="body_temperature")
	private String bodyTemperature;
		 
	public CcmAssessmentSensorReadings() {}

	/**
	 * Constructor
	 * 
	 * @param visit
	 * @param heartRate
	 * @param respiratoryRate
	 * @param bodyTemperature 
	 * 
	 */
	public CcmAssessmentSensorReadings(CcmPatientVisit visit, String heartRate, String respiratoryRate, String bodyTemperature) {	
		setVisit(visit);
		setHeartRate(heartRate);
		setRespiratoryRate(respiratoryRate);
		setBodyTemperature(bodyTemperature);
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

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public String getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(String bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}
}
