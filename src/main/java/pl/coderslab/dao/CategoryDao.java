package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.Category;

public interface CategoryDao {
	
	List<Category> getAllCategoriesAlphabetically();

}
