package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.dao.GenericDao;
import pl.coderslab.entity.User;

@Service
public class UserServiceImpl implements GenericService<User> {
	
	@Autowired
	GenericDao<User> userDao;

	@Override
	public void saveEntity(User entity) {
		userDao.saveEntity(entity);
	}

	@Override
	public List<User> getAllEntities(Class<User> entityClass) {
		return userDao.getAllEntities(User.class);
	}

	@Override
	public void deleteEntityById(Class<User> entityClass, long id) {
		userDao.deleteEntityById(User.class, id);
	}

	@Override
	public void updateEntity(User entity) {
		userDao.updateEntity(entity);
	}

	@Override
	public User getEntityById(Class<User> entityClass, long id) {
		return userDao.getEntityById(User.class, id);
	}
}
