package ie.ucc.bis.ccm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sl_ccm_patient_details")
public class Patient implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="patient_id")
	@GeneratedValue
	private long patientId;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="surname")
	private String surname;
	
	public Patient() {}

	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param surname
	 */
	public Patient(String firstName, String surname) {
		this.setFirstName(firstName);
		this.setSurname(surname);
	}	
	
	/**
	 * Constructor
	 * 
	 * @param patientId
	 * @param firstName
	 * @param surname
	 */
	public Patient(long patientId, String firstName, String surname) {
		this.setPatientId(patientId);
		this.setFirstName(firstName);
		this.setSurname(surname);
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}	
}
