package ie.ucc.bis.supportinglife.communication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
	private Date startSurveillanceDate;
	private Date endSurveillanceDate;


	public SurveillanceRequestComms() {
		setClassificationKeys(new ArrayList<String>());
	}

	public List<String> getClassificationKeys() {
		return classificationKeys;
	}

	public void setClassificationKeys(List<String> classificationKeys) {
		this.classificationKeys = classificationKeys;
	}

	public Date getStartSurveillanceDate() {
		return startSurveillanceDate;
	}

	public void setStartSurveillanceDate(Date startSurveillanceDate) {
		this.startSurveillanceDate = startSurveillanceDate;
	}

	public Date getEndSurveillanceDate() {
		return endSurveillanceDate;
	}

	public void setEndSurveillanceDate(Date endSurveillanceDate) {
		this.endSurveillanceDate = endSurveillanceDate;
	}
}
