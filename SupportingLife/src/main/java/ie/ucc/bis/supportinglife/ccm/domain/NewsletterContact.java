package ie.ucc.bis.supportinglife.ccm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Domain class capturing an email address newsletter contact of the SL project
 * (note: newsletter contacts originate from the SL landing page)
 * 
 * @author TOSullivan
 */
@Entity
@Table(name="sl_newsletter_contacts")
public class NewsletterContact implements Serializable {
	
	/**
	 * Generated Serial Version Id
	 */
	private static final long serialVersionUID = 4329198176881892035L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;

	@Column(name="email")
	private String email;

	public NewsletterContact() {}

	public NewsletterContact(String email) {
		setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
