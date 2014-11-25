package ie.ucc.bis.supportinglife.form;


/**
 * Bean to capture information from User Creation Form
 * 
 * @author TOSullivan
 */

public class UserCreationForm  {
	
	private String userId;
	private String password;
	private String firstName;
	private String surname;
	private Boolean ccmRole;
	private Boolean imciRole;
	private Boolean adminRole;

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

	public Boolean getCcmRole() {
		return ccmRole;
	}

	public void setCcmRole(Boolean ccmRole) {
		this.ccmRole = ccmRole;
	}

	public Boolean getImciRole() {
		return imciRole;
	}

	public void setImciRole(Boolean imciRole) {
		this.imciRole = imciRole;
	}

	public Boolean getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(Boolean adminRole) {
		this.adminRole = adminRole;
	}

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("\n" + "userID: " + getUserId() + "\n");
        stringBuilder.append("firstName: " + getFirstName()  + "\n");
        stringBuilder.append("surname: " + getSurname() + "\n");
        stringBuilder.append("ccm role: " + getCcmRole() + "\n");
        stringBuilder.append("imci role: " + getImciRole() + "\n");
        stringBuilder.append("admin role: " + getAdminRole() + "\n");
        
        return stringBuilder.toString();
	}
	
}
