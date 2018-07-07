package pl.coderslab.metamodel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import pl.coderslab.entity.Authority;

@StaticMetamodel(Authority.class)
public class Authority_ {

	public static volatile SingularAttribute<Authority, Long> id;
	public static volatile SingularAttribute<Authority, String> username;
	public static volatile SingularAttribute<Authority, String> authority;

}
