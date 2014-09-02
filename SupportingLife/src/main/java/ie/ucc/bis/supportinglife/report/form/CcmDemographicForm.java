package ie.ucc.bis.supportinglife.report.form;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * Bean to capture information from CCM Demographic Form
 * 
 * @author TOSullivan
 */

public class CcmDemographicForm  {
	
	private String patientId;
	private String nationalId;
	private String nationalHealthId;
	private String hsaUserId;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date assessmentDateFrom;
    
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date assessmentDateTo;
    
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getNationalId() {
		return nationalId;
	}
	
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	
	public String getNationalHealthId() {
		return nationalHealthId;
	}
	
	public void setNationalHealthId(String nationalHealthId) {
		this.nationalHealthId = nationalHealthId;
	}
	
	public String getHsaUserId() {
		return hsaUserId;
	}
	
	public void setHsaUserId(String hsaUserId) {
		this.hsaUserId = hsaUserId;
	}
	
	public Date getAssessmentDateFrom() {
		return assessmentDateFrom;
	}
	
	public void setAssessmentDateFrom(Date assessmentDateFrom) {
		this.assessmentDateFrom = assessmentDateFrom;
	}
	
	public Date getAssessmentDateTo() {
		return assessmentDateTo;
	}
	
	public void setAssessmentDateTo(Date assessmentDateTo) {
		this.assessmentDateTo = assessmentDateTo;
	}

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("\n" + "nationalID: " + getNationalId() + "\n");
        stringBuilder.append("nationalHealthID: " + getNationalHealthId()  + "\n");
        stringBuilder.append("hsaUserId: " + getHsaUserId() + "\n");
        
        stringBuilder.append("assessment date from: " + getAssessmentDateFrom() + "\n");
        stringBuilder.append("assessment date to: " + getAssessmentDateTo()  + "\n");
        
        return stringBuilder.toString();
	}
	
}
