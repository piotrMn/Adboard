package pl.coderslab.metamodel;

import java.sql.Timestamp;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.User;

@StaticMetamodel(Ad.class)
public class Ad_ {
	
	public static volatile SingularAttribute<Ad, Long> id;
	public static volatile SingularAttribute<Ad, String> title;
	public static volatile SingularAttribute<Ad, String> description;
	public static volatile SingularAttribute<Ad, String> location;
	public static volatile SingularAttribute<Ad, Timestamp> creationTimestamp;
	public static volatile SingularAttribute<Ad, Timestamp> expiryTimestamp;
	public static volatile SingularAttribute<Ad, User> user;
	public static volatile ListAttribute<Ad, Category> categories;
	public static volatile ListAttribute<Ad, Comment> comments;
	
}
