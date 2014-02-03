package ie.ucc.bis.supportinglife.report.form;


import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;
import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * Bean to capture information from CCM Custom Form
 * 
 * @author TOSullivan
 */

public class CcmCustomForm  {
	
	private String nationalId;
	private String nationalHealthId;
	private String hsaUserId;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date assessmentDateFrom;
    
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date assessmentDateTo;
    
    private List<CheckboxFormElement> lookSymptoms;
    private List<CheckboxFormElement> askLookSymptoms;    
    private List<CheckboxFormElement> classifications;  
    private List<Treatment> treatments;
    
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
	
	public List<CheckboxFormElement> getLookSymptoms() {
		return lookSymptoms;
	}

	public void setLookSymptoms(List<CheckboxFormElement> lookSymptoms) {
		this.lookSymptoms = lookSymptoms;
	}

	public List<CheckboxFormElement> getAskLookSymptoms() {
		return askLookSymptoms;
	}

	public void setAskLookSymptoms(List<CheckboxFormElement> askLookSymptoms) {
		this.askLookSymptoms = askLookSymptoms;
	}

	public List<CheckboxFormElement> getClassifications() {
		return classifications;
	}

	public void setClassifications(List<CheckboxFormElement> classifications) {
		this.classifications = classifications;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("\n" + "nationalID: " + getNationalId() + "\n");
        stringBuilder.append("nationalHealthID: " + getNationalHealthId()  + "\n");
        stringBuilder.append("hsaUserId: " + getHsaUserId() + "\n");
        
        stringBuilder.append("assessment date from: " + getAssessmentDateFrom() + "\n");
        stringBuilder.append("assessment date to: " + getAssessmentDateTo()  + "\n");
        
        for (CheckboxFormElement symptom : getLookSymptoms()){
        	stringBuilder.append("symptom (look) value: " + symptom.getValue() + "\n");
        	stringBuilder.append("symptom (look) key: " + symptom.getKey() + "\n");
        	stringBuilder.append("symptom (look) checked: " + symptom.getChecked() + "\n");
        }
        
        for (CheckboxFormElement symptom : getAskLookSymptoms()){
        	stringBuilder.append("symptom (ask) value: " + symptom.getValue() + "\n");
        	stringBuilder.append("symptom (ask) key: " + symptom.getKey() + "\n");
        	stringBuilder.append("symptom (ask) checked: " + symptom.getChecked() + "\n");
        }
        
        for (CheckboxFormElement classification : getClassifications()){
        	stringBuilder.append("classification value: " + classification.getValue() + "\n");
        	stringBuilder.append("classification key: " + classification.getKey() + "\n");
        	stringBuilder.append("classification checked: " + classification.getChecked() + "\n");
        }

        for (Treatment treatment : getTreatments()){
        	stringBuilder.append("treatment value: " + treatment.getValue() + "\n");
        	stringBuilder.append("treatment key: " + treatment.getKey() + "\n");
        	stringBuilder.append("treatment checked: " + treatment.getChecked() + "\n");
        	stringBuilder.append("associated classification: " + treatment.getAssociatedClassification() + "\n");
        }
 
        return stringBuilder.toString();
	}
	
}
