package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.User;
import ie.ucc.bis.supportinglife.form.UserCreationForm;

public interface UserDao extends Dao {

	public User getUserByUserId(String userId);
	public boolean authenticateUser(String userId, String password);
	public void registerUser(User user);
	public void addUser(UserCreationForm userDetails);
}
