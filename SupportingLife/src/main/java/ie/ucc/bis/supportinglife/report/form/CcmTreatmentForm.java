package ie.ucc.bis.supportinglife.report.form;


import ie.ucc.bis.supportinglife.reference.Treatment;

import java.util.List;


/**
 * Bean to capture information from CCM Treatment Form
 * 
 * @author TOSullivan
 */

public class CcmTreatmentForm  {
	
    private List<Treatment> treatments;
    
	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        for (Treatment treatment : getTreatments()){
        	stringBuilder.append("treatment value: " + treatment.getValue() + "\n");
        	stringBuilder.append("treatment key: " + treatment.getKey() + "\n");
        	stringBuilder.append("treatment checked: " + treatment.getChecked() + "\n");
        	stringBuilder.append("associated classification: " + treatment.getAssociatedClassification() + "\n");
        }
        return stringBuilder.toString();
	}
	
}
