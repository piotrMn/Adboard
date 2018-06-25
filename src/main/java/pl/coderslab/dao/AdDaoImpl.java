package pl.coderslab.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;

@Repository
public class AdDaoImpl implements AdDao {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveAd(Ad ad) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(ad);
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
	public List<Ad> getAllCurrentAds() {
		Session session = null;
		Transaction tx = null;
		List<Ad> currentAds = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<Ad> query = session.createQuery("from Ad ad where ad.expiryTimestamp>:now");
			query.setParameter("now", Timestamp.valueOf(LocalDateTime.now()));
			currentAds = query.getResultList();
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
		return currentAds;
	}

	@Override
	public List<Ad> getAllAdsByUserId(Long id) {
		Session session = null;
		Transaction tx = null;
		List<Ad> allAds = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<Ad> query = session.createQuery("select ad from Ad ad join ad.user u where u.id=:id");
			query.setParameter("id", id);
			allAds = query.getResultList();
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
		return allAds;
	}

	@Override
	public void deleteAdById(long id) {
		Session session = null;
		Transaction tx = null;
		Ad thisAd = null;
		User thisUser = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			thisAd = session.get(Ad.class, id);
			thisUser = session.get(User.class, thisAd.getUser().getId());
			thisUser.getAds().remove(thisAd);
			session.delete(thisAd);
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
	public Ad getAdById(long id) {
		Session session = null;
		Transaction tx = null;
		Ad thisAd = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			thisAd = session.get(Ad.class, id);
			session.delete(thisAd);
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
		return thisAd;
	}
}
