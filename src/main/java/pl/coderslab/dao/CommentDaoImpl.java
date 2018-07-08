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
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.CommentDTO;
import pl.coderslab.entity.User;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Comment> getCommentsByAdId(long id) {
		Session session = null;
		Transaction tx = null;
		List<Comment> comments = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Comment> criteria = builder.createQuery(Comment.class);
			Root<Comment> root = criteria.from(Comment.class);
			criteria.select(root).where(builder.equal(root.get("user").get("id"), id))
					.orderBy(builder.desc(root.get("creationTimestamp")));
			comments = session.createQuery(criteria).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		return comments;
	}

	@Override
	public void saveComment(CommentDTO commentDTO) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			User thisUser = session.get(User.class, commentDTO.getUserId());
			Ad thisAd = session.get(Ad.class, commentDTO.getAdId());
			Comment newComment = new Comment();
			newComment.setContent(commentDTO.getContent());
			newComment.setAd(thisAd);
			newComment.setUser(thisUser);
			newComment.setCreationTimestamp(Timestamp.valueOf(LocalDateTime.now()));
			thisAd.getComments().add(newComment);
			session.save(newComment);
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
