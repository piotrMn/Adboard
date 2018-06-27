package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.dao.GenericDao;

@Service
public class GeneralServiceImpl<T> implements GeneralService<T> {
	
	@Autowired
	GenericDao<T> genericDao;

	@Override
	public void saveEntity(T entity) {
		genericDao.saveEntity(entity);
	}

	@Override
	public List<T> getAllEntities(Class<T> entityClass) {
		return genericDao.getAllEntities(entityClass);
	}

	@Override
	public void updateEntity(T entity) {
		genericDao.updateEntity(entity);
	}

	@Override
	public T getEntityById(Class<T> entityClass, long id) {
		return genericDao.getEntityById(entityClass, id);
	}

	@Override
	public void deleteEntityById(Class<T> entityClass, long id) {
		genericDao.deleteEntityById(entityClass, id);
	}



}
