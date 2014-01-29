package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Domain class capturing a CcmPatient entity
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_ccm_patient")
public class CcmPatient implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -6120098477412745960L;

	@Id
	@Column(name="patient_id")
	@GeneratedValue
	private Long patientId;
	
	@Column(name="national_id")
	private String nationalId;
	
	@Column(name="national_health_id")
	private String nationalHealthId;
	
	// association to sl_user table
	// - one user can create many patients 
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
	
	@Column(name="child_first_name")
	private String childFirstName;

	@Column(name="child_surname")
	private String childSurname;
	
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="caregiver_name")
	private String caregiverName;

	@Column(name="relationship")
	private String relationship;
	
	@Column(name="other_relationship")
	private String otherRelationship;
	
	@Column(name="physical_address")
	private String physicalAddress;
	
	@Column(name="village_ta")
	private String villageTa;
	
	@Column(name="created_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="updated_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	 
	public CcmPatient() {}

	/**
	 * Constructor
	 * 
	 * @param user
	 * @param childFirstName
	 * @param childSurname
	 * @param birthDate
	 * @param gender
	 * @param caregiverName
	 * @param relationship
	 * @param otherRelationship
	 * @param physicalAddress
	 * @param villageTa
	 * @param createdDate
	 * @param updatedDate
	 */
	public CcmPatient(User user, String childFirstName, String childSurname, Date birthDate,
					String gender, String caregiverName, String relationship, 
					String otherRelationship, String physicalAddress, String villageTa,
					Date createdDate, Date updatedDate) {
		
		setUser(user);
		setChildFirstName(childFirstName);
		setChildSurname(childSurname);
		setBirthDate(birthDate);
		setGender(gender);
		setCaregiverName(caregiverName);
		setRelationship(relationship);
		setOtherRelationship(otherRelationship);
		setPhysicalAddress(physicalAddress);
		setVillageTa(villageTa);
		setCreatedDate(createdDate);
		setUpdatedDate(updatedDate);
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getNationalHealthId() {
		return nationalHealthId;
	}

	public void setNationalHealthId(String nationalHealthId) {
		this.nationalHealthId = nationalHealthId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getChildFirstName() {
		return childFirstName;
	}

	public void setChildFirstName(String childFirstName) {
		this.childFirstName = childFirstName;
	}

	public String getChildSurname() {
		return childSurname;
	}

	public void setChildSurname(String childSurname) {
		this.childSurname = childSurname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCaregiverName() {
		return caregiverName;
	}

	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getOtherRelationship() {
		return otherRelationship;
	}

	public void setOtherRelationship(String otherRelationship) {
		this.otherRelationship = otherRelationship;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getVillageTa() {
		return villageTa;
	}

	public void setVillageTa(String villageTa) {
		this.villageTa = villageTa;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}	
}
