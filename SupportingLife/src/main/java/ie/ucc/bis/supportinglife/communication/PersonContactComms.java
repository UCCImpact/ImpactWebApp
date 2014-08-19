package ie.ucc.bis.supportinglife.communication;

import java.io.Serializable;


/** 
 * @author timothyosullivan
 */

public class PersonContactComms implements Serializable {

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = 3574474496504314380L;

	
	// Person Contact Details
	private String name;
	private String email;
	private String phone;
	private String comment;

	public PersonContactComms() {}

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
