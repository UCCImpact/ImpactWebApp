package ie.ucc.bis.supportinglife.communication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/** 
 * @author timothyosullivan
 */

public class SurveillanceRequestComms implements Serializable {

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = -3121899756496109163L;

	private List<String> classificationKeys;
	private String startSurveillanceDate;
	private String endSurveillanceDate;


	public SurveillanceRequestComms() {
		setClassificationKeys(new ArrayList<String>());
	}

	public List<String> getClassificationKeys() {
		return classificationKeys;
	}

	public void setClassificationKeys(List<String> classificationKeys) {
		this.classificationKeys = classificationKeys;
	}

	public String getStartSurveillanceDate() {
		return startSurveillanceDate;
	}

	public void setStartSurveillanceDate(String startSurveillanceDate) {
		this.startSurveillanceDate = startSurveillanceDate;
	}

	public String getEndSurveillanceDate() {
		return endSurveillanceDate;
	}

	public void setEndSurveillanceDate(String endSurveillanceDate) {
		this.endSurveillanceDate = endSurveillanceDate;
	}
}
