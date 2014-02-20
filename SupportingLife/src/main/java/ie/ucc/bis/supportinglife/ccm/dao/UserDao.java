package ie.ucc.bis.supportinglife.ccm.dao;

import java.util.List;

import ie.ucc.bis.supportinglife.ccm.domain.User;

public interface UserDao extends Dao {

	public List<User> getUserByUserId(String userId);
}
