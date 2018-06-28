package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.dao.GenericDao;
import pl.coderslab.entity.Category;

@Service
public class CatServiceImpl implements GeneralService<Category> {
	
	@Autowired
	GenericDao<Category> genDao;

	@Override
	public void saveEntity(Category entity) {
		genDao.saveEntity(entity);
	}

	@Override
	public List<Category> getAllEntities(Class<Category> entityClass) {
		return genDao.getAllEntities(Category.class);
	}

	@Override
	public void deleteEntityById(Class<Category> entityClass, long id) {
		genDao.deleteEntityById(Category.class, id);
	}

	@Override
	public void updateEntity(Category entity) {
		genDao.updateEntity(entity);
	}

	@Override
	public Category getEntityById(Class<Category> entityClass, long id) {
		return genDao.getEntityById(Category.class, id);
	}

}
