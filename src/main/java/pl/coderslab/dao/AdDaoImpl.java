package pl.coderslab.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;

@Repository
public class AdDaoImpl implements AdDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Ad> getAllCurrentAds() {
		Session session = null;
		Transaction tx = null;
		List<Ad> currentAds = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Ad> criteria = builder.createQuery(Ad.class);
			Root<Ad> adRoot = criteria.from(Ad.class);
			criteria.select(adRoot)
					.where(builder.greaterThan(adRoot.get("expiryTimestamp"), Timestamp.valueOf(LocalDateTime.now())));
			currentAds = session.createQuery(criteria).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		return currentAds;
	}

	@Override
	public List<Ad> getAllAdsByUserId(long id) {
		Session session = null;
		Transaction tx = null;
		List<Ad> allAds = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Ad> criteria = builder.createQuery(Ad.class);
			Root<Ad> adRoot = criteria.from(Ad.class);
			criteria.select(adRoot).where(builder.equal(adRoot.get("user").get("id"), id));
			allAds = session.createQuery(criteria).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		return allAds;
	}

	@Override
	public void deleteAdById(long id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Ad thisAd = session.get(Ad.class, id);
			thisAd.getUser().getAds().remove(thisAd);
			for (Category category : thisAd.getCategories()) {
				category.getAds().remove(thisAd);
			}
			session.delete(thisAd);
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
