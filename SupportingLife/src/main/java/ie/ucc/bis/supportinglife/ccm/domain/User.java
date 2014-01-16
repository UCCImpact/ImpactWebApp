package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sl_user")
public class User implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -3371255273833222616L;

	@Id
	@Column(name="user_id")
	@GeneratedValue
	private String userId;
	
	@Column(name="password")
	private String password;

	@Column(name="ccm_user")
	private int ccmUser;
	
	@Column(name="imci_user")
	private int imciUser;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="role")
	private String role;	
	
	@Column(name="created_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="updated_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	public User() {}

	/**
	 * Constructor
	 * 
	 * @param password
	 * @param ccmUser
	 * @param imciUser
	 * @param firstName
	 * @param surname
	 * @param role
	 * @param createdDate
	 * @param updatedDate
	 */
	public User(String password, int ccmUser, int imciUser, String firstName,
				String surname, String role, Date createdDate, Date updatedDate) {
		setPassword(password);
		setCcmUser(ccmUser);
		setImciUser(imciUser);
		setFirstName(firstName);
		setSurname(surname);
		setRole(role);
		setCreatedDate(createdDate);
		setUpdatedDate(updatedDate);
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

	public int getCcmUser() {
		return ccmUser;
	}

	public void setCcmUser(int ccmUser) {
		this.ccmUser = ccmUser;
	}

	public int getImciUser() {
		return imciUser;
	}

	public void setImciUser(int imciUser) {
		this.imciUser = imciUser;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
