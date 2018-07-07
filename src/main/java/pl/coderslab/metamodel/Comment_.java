package pl.coderslab.metamodel;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.User;

@StaticMetamodel(Comment.class)
public class Comment_ {

	public static volatile SingularAttribute<Comment, Long> id;
	public static volatile SingularAttribute<Comment, String> content;
	public static volatile SingularAttribute<Comment, Timestamp> creationTimestamp;
	public static volatile SingularAttribute<Comment, User> user;
	public static volatile SingularAttribute<Comment, Ad> ad;
	
}
