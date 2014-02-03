
package ie.ucc.bis.supportinglife.reference;


import java.util.List;
import java.util.Map;

public class CcmCustomReportReferenceCriteria {

	private List<CheckboxFormElement> lookSymptoms;
	private List<CheckboxFormElement> askLookSymptoms;
	private List<CheckboxFormElement> classifications;
	private Map<String, String> classificationTypes;
	private List<Treatment> treatments;

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
	
	public Map<String, String> getClassificationTypes() {
		return classificationTypes;
	}

	public void setClassificationTypes(Map<String, String> classificationTypes) {
		this.classificationTypes = classificationTypes;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}
	
	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}
}
