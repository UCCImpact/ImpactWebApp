package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Domain class providing reference for CCM classifications
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_classification")
public class CcmClassification implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -8654916925176669313L;

	@Id
	@Column(name="classification_id")
	@GeneratedValue
	private Long classificationId;

	@Column(name="classification_key")
	private String classificationKey;
	
	@Column(name="classification_name")
	private String classificationName;
			 
	public CcmClassification() {}

	/**
	 * Constructor
	 * 
	 * @param classificationId
	 * @param name
	 */
	public CcmClassification(Long classificationId, String classificationKey, String classificationName) {
		setClassificationId(classificationId);
		setClassificationKey(classificationKey);
		setClassificationName(classificationName);
	}

	public Long getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Long classificationId) {
		this.classificationId = classificationId;
	}

	public String getClassificationKey() {
		return classificationKey;
	}

	public void setClassificationKey(String classificationKey) {
		this.classificationKey = classificationKey;
	}

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}



}
