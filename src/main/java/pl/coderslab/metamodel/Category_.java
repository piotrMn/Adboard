package pl.coderslab.metamodel;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;

@StaticMetamodel(Category.class)
public class Category_ {
	
	public static volatile SingularAttribute<Category, Long> id;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile SingularAttribute<Category, String> description;
	public static volatile ListAttribute<Category, Ad>	ads;
	
}
