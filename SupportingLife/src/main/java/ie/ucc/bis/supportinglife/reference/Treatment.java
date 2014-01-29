package ie.ucc.bis.supportinglife.reference;

public class Treatment {
	
	private String key;
	private String value;
	private boolean checked;
	private String associatedClassification;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getChecked() {
		return isChecked();
	}
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getAssociatedClassification() {
		return associatedClassification;
	}

	public void setAssociatedClassification(String associatedClassification) {
		this.associatedClassification = associatedClassification;
	}

}
