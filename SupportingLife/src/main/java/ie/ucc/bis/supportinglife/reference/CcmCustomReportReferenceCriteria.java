
package ie.ucc.bis.supportinglife.reference;

import java.util.Map;

public class CcmCustomReportReferenceCriteria {

	private Map<String, String> askLookSymptoms;
	private Map<String, String> classifications;
	private Map<String, String> classificationTypes;
	private Map<String, String> treatments;

	public Map<String, String> getAskLookSymptoms() {
		return askLookSymptoms;
	}

	public void setAskLookSymptoms(Map<String, String> askLookSymptoms) {
		this.askLookSymptoms = askLookSymptoms;
	}

	public Map<String, String> getClassifications() {
		return classifications;
	}

	public void setClassifications(Map<String, String> classifications) {
		this.classifications = classifications;
	}

	public Map<String, String> getClassificationTypes() {
		return classificationTypes;
	}

	public void setClassificationTypes(Map<String, String> classificationTypes) {
		this.classificationTypes = classificationTypes;
	}

	public Map<String, String> getTreatments() {
		return treatments;
	}

	public void setTreatments(Map<String, String> treatments) {
		this.treatments = treatments;
	}

}
