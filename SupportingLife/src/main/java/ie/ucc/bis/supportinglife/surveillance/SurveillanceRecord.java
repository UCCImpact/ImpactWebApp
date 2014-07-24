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

	private String classificationName;
	private String latitude;
	private String longitude;

	public String getClassificationName() {
		return classificationName;
	}
	
	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
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
}
