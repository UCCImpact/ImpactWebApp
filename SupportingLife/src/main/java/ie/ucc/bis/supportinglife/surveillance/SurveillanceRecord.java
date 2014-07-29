package ie.ucc.bis.supportinglife.surveillance;

import java.io.Serializable;

/**
 * Represents a data surveillance record
 * 
 * @author TOSullivan
 */
public class SurveillanceRecord implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = 2323662119607857234L;

	private String patientId;
	private String assessmentDate;
	private String latitude;
	private String longitude;
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(String assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public boolean equals(Object other) {
		if (getLongitude().equalsIgnoreCase(((SurveillanceRecord) other).getLongitude()) && getLatitude().equalsIgnoreCase(((SurveillanceRecord) other).getLatitude())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
    public int hashCode() {
		return ((Double) (Double.valueOf(getLatitude()) * Double.valueOf(getLongitude()))).intValue();
	}
	
}
