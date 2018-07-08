package pl.coderslab.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Authority;
import pl.coderslab.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUserWithRoles(User user, Role[] roles) {
		Session session = null;
		Transaction tx = null;
		Authority[] authorities = new Authority[roles.length];
		for (int i = 0; i < authorities.length; i++) {
			authorities[i] = new Authority(user.getUsername(), roles[i].toString());
		}
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			for (int i = 0; i < authorities.length; i++) {
				session.save(authorities[i]);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = null;
		Transaction tx = null;
		User thisUser = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> userRoot = criteria.from(User.class);
			criteria.select(userRoot).where(builder.equal(userRoot.get("username"), username));
			try {
				thisUser = session.createQuery(criteria).getSingleResult();
			} catch (NoResultException e) {
				thisUser = null;
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		return thisUser;
	}

	@Override
	public void deleteUserByUsernameWithRoles(String username) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> userCriteria = builder.createQuery(User.class);
			Root<User> userRoot = userCriteria.from(User.class);
			userCriteria.select(userRoot).where(builder.equal(userRoot.get("username"), username));
			User thisUser = session.createQuery(userCriteria).getSingleResult();
			CriteriaQuery<Authority> authorityCriteria = builder.createQuery(Authority.class);
			Root<Authority> authorityRoot = authorityCriteria.from(Authority.class);
			authorityCriteria.select(authorityRoot)
					.where(builder.equal(authorityRoot.get("username"), username));
			List<Authority> theAuthorities = session.createQuery(authorityCriteria).getResultList();
			session.delete(thisUser);
			for (Authority authority : theAuthorities) {
				session.delete(authority);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
}
