package ie.ucc.bis.supportinglife.ccm.dao;

import ie.ucc.bis.supportinglife.ccm.domain.User;
import ie.ucc.bis.supportinglife.ccm.domain.User_;
import ie.ucc.bis.supportinglife.utilities.DateUtilities;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUserByUserId(String userId) {	
		User user = entityManager.find(User.class, userId);

		return user;
	}

	@Override
	public boolean authenticateUser(String userId, String password) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);

		criteriaQuery.select(root)
		.where(criteriaBuilder.and(
				criteriaBuilder.equal(root.get(User_.userId), userId),
				criteriaBuilder.equal(root.get(User_.password), password)));

		if (entityManager.createQuery(criteriaQuery).getResultList().size() != 1) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void registerUser(User user) {
		Date currentDate = DateUtilities.getTodaysDate(DateUtilities.DATE_TIME_CUSTOM_FORMAT);
		user.setRegisteredDate(currentDate);
		entityManager.persist(user);
		// save to DB
		entityManager.flush();
		entityManager.clear();
	}
}
