package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Domain class capturing a user entity
 * (e.g. HSA user)
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_user")
public class User implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -3371255273833222616L;

	@Id
	@Column(name="user_id")
	private String userId;
	
	/* password column is case sensitive */
	@Column(name="password")
	private String password;

	@Column(name="ccm_user", columnDefinition = "TINYINT(1)")
	private boolean ccmUser;
	
	@Column(name="imci_user", columnDefinition = "TINYINT(1)")
	private boolean imciUser;
	
	@Column(name="admin_user", columnDefinition = "TINYINT(1)")
	private boolean adminUser;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="created_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="updated_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@Column(name="registered_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredDate;

	// association to sl_ccm_patient_visit table
	// - one user can create many patients 
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<CcmPatientVisit> ccmPatientVisitList;


	public User() {}

	/**
	 * Constructor
	 */
	public User(String userId, String password, String firstName, String surname) {
		setUserId(userId);
		setPassword(password);
		setFirstName(firstName);
		setSurname(surname);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getCcmUser() {
		return ccmUser;
	}

	public void setCcmUser(boolean ccmUser) {
		this.ccmUser = ccmUser;
	}

	public boolean getImciUser() {
		return imciUser;
	}

	public void setImciUser(boolean imciUser) {
		this.imciUser = imciUser;
	}

	public boolean isAdminUser() {
		return adminUser;
	}

	public void setAdminUser(boolean adminUser) {
		this.adminUser = adminUser;
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

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Set<CcmPatientVisit> getCcmPatientVisitList() {
		return ccmPatientVisitList;
	}

	public void setCcmPatientVisitList(Set<CcmPatientVisit> ccmPatientVisitList) {
		this.ccmPatientVisitList = ccmPatientVisitList;
	}	
	
}
