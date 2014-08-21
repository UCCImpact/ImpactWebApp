package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.communication.PersonContactComms;

public interface ContactsDao extends Dao {
	public void addPersonContact(PersonContactComms personContact);
}
