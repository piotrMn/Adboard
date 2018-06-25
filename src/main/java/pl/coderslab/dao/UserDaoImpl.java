package pl.coderslab.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Authority;
import pl.coderslab.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUserWithRole(User user, Role role) {
		Session session = null;
		Transaction tx = null;
		Authority auth = new Authority();
		auth.setUsername(user.getUsername());
		auth.setAuthority(role.toString());
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			session.save(auth);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (HibernateException he) {
				logger.error("Could not rollback transaction!");
			}
		} finally {
			session.close();
		}
	}

	@Override
	public User getUserById(long id) {
		Session session = null;
		Transaction tx = null;
		User thisUser = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			thisUser = session.get(User.class, id);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (HibernateException he) {
				logger.error("Could not rollback transaction!");
			}
		} finally {
			session.close();
		}
		return thisUser;
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = null;
		Transaction tx = null;
		User thisUser = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query<User> query = session.createQuery("from User u where u.username=:username");
			query.setParameter("username", username);
			thisUser = query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (HibernateException he) {
				logger.error("Could not rollback transaction!");
			}
		} finally {
			session.close();
		}
		return thisUser;
	}
}
