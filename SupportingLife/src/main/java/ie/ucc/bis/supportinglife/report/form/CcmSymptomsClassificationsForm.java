package ie.ucc.bis.supportinglife.report.form;


import ie.ucc.bis.supportinglife.reference.CheckboxFormElement;

import java.util.List;


/**
 * Bean to capture information from CCM Symptoms/Classifications Form
 * 
 * @author TOSullivan
 */

public class CcmSymptomsClassificationsForm  {
	    
    private List<CheckboxFormElement> lookSymptoms;
    private List<CheckboxFormElement> askLookSymptoms;    
    private List<CheckboxFormElement> classifications;  
    	
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

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
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
 
        return stringBuilder.toString();
	}
	
}
