package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.Contact;
import ie.ucc.bis.supportinglife.ccm.domain.NewsletterContact;
import ie.ucc.bis.supportinglife.communication.PersonContactComms;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ContactsDaoImpl implements ContactsDao {

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void addPersonContact(PersonContactComms personContact) {
		Contact contact = new Contact(personContact);

		entityManager.persist(contact);
		// save to DB
		entityManager.flush();
		entityManager.clear();
	}
	
	public void addNewsletterContact(String emailAddress) {
		NewsletterContact newsletterContact = new NewsletterContact(emailAddress);
		
		entityManager.persist(newsletterContact);
		// save to DB
		entityManager.flush();
		entityManager.clear();
	}
}
