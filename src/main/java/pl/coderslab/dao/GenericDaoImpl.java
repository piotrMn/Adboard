package pl.coderslab.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {
	
	private static final Logger LOGGER = LogManager.getLogger(GenericDaoImpl.class.getName() );
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveEntity(Object object) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (HibernateException he) {
				LOGGER.error("Could not rollback transaction!");
			}
		} finally {
			session.close();
		}
	}

	@Override
	public List<T> getAllEntities(Class<T> entityClass) {
		Session session = null;
		Transaction tx = null;
		List<T> list = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> cq = builder.createQuery(entityClass);
			Root<T> root = cq.from(entityClass);
			CriteriaQuery<T> all = cq.select(root);
			Query<T> sq = session.createQuery(all);
			list = sq.getResultList();
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (HibernateException he) {
				LOGGER.error("Could not rollback transaction!");
			}
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void deleteEntityById(Class<T> entityClass, long id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			T thisObject = session.get(entityClass, id);
			session.delete(thisObject);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (HibernateException he) {
				LOGGER.error("Could not rollback transaction!");
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void updateEntity(T entity) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(entity);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (HibernateException he) {
				LOGGER.error("Could not rollback transaction!");
			}
		} finally {
			session.close();
		}
	}

	@Override
	public T getEntityById(Class<T> entityClass, long id) {
		Session session = null;
		Transaction tx = null;
		T thisObject = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			thisObject = session.get(entityClass, id);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (HibernateException he) {
				LOGGER.error("Could not rollback transaction!");
			}
		} finally {
			session.close();
		}
		return thisObject;
	}

}
