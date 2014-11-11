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
@Table(name="sl_ccm_treatment")
public class CcmTreatment implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -5779067410947126193L;

	@Id
	@Column(name="treatment_id")
	@GeneratedValue
	private Long treatmentId;

	@Column(name="treatment_key")
	private String treatmentKey;
	
	@Column(name="description")
	private String description;
	
	@Column(name="drug_administered", columnDefinition = "TINYINT(1)")
	private boolean drugAdministered;

	@Column(name="treatment_administered", columnDefinition = "TINYINT(1)")
	private boolean treatmentAdministered;
			 
	public CcmTreatment() {}

	/**
	 * Constructor
	 * 
	 * @param classificationId
	 * @param name
	 */
	public CcmTreatment(String treatmentKey, String description, boolean drugAdministered, boolean treatmentAdministered) {
		setTreatmentKey(treatmentKey);
		setDescription(description);
		setDrugAdministered(drugAdministered);
		setTreatmentAdministered(treatmentAdministered);
	}

	public Long getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Long treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getTreatmentKey() {
		return treatmentKey;
	}

	public void setTreatmentKey(String treatmentKey) {
		this.treatmentKey = treatmentKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDrugAdministered() {
		return drugAdministered;
	}

	public void setDrugAdministered(boolean drugAdministered) {
		this.drugAdministered = drugAdministered;
	}

	public boolean isTreatmentAdministered() {
		return treatmentAdministered;
	}

	public void setTreatmentAdministered(boolean treatmentAdministered) {
		this.treatmentAdministered = treatmentAdministered;
	}
}
