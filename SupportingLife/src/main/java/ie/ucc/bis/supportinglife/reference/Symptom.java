package ie.ucc.bis.supportinglife.reference;

public class Symptom {
	
	private String key;
	private String value;
	private boolean checked;

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

	boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
