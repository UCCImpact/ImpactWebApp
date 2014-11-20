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

	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("\n" + "userID: " + getUserId() + "\n");
        stringBuilder.append("firstName: " + getFirstName()  + "\n");
        stringBuilder.append("surname: " + getSurname() + "\n");

        
        return stringBuilder.toString();
	}
	
}
