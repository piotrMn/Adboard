package pl.coderslab.metamodel;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import pl.coderslab.entity.User;

@StaticMetamodel(User.class)
public class User_ {
	
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> fullname;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Integer> enabled;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, Timestamp> creationTimestamp;
	
}
