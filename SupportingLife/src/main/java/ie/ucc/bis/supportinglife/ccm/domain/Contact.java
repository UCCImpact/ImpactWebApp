package ie.ucc.bis.supportinglife.ccm.domain;

import ie.ucc.bis.supportinglife.communication.PersonContactComms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Domain class capturing a person contact of the SL project
 * (note: contacts originate from the SL landing page)
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_contacts")
public class Contact implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = -5371439540403427078L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="comment")
	private String comment;

	public Contact() {}

	public Contact(PersonContactComms personContact) {
		setName(personContact.getName());
		setEmail(personContact.getEmail());
		setPhone(personContact.getPhone());
		setComment(personContact.getComment());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}	
}
