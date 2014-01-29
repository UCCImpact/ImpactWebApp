
package ie.ucc.bis.supportinglife.reference;

import java.util.List;
import java.util.Map;

public class CcmCustomReportReferenceCriteria {

	private List<Symptom> askLookSymptoms;
	private List<Classification> classifications;
	private Map<String, String> classificationTypes;
	private List<Treatment> treatments;
	
	public List<Symptom> getAskLookSymptoms() {
		return askLookSymptoms;
	}
	
	public void setAskLookSymptoms(List<Symptom> askLookSymptoms) {
		this.askLookSymptoms = askLookSymptoms;
	}
	
	public List<Classification> getClassifications() {
		return classifications;
	}
	
	public void setClassifications(List<Classification> classifications) {
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
