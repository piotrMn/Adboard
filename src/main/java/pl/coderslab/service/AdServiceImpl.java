package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.dao.GenericDao;
import pl.coderslab.entity.Ad;

@Service
public class AdServiceImpl implements GenericService<Ad> {
	
	@Autowired
	GenericDao<Ad> genDao;
	
	@Override
	public void saveEntity(Ad entity) {
		genDao.saveEntity(entity);
	}

	@Override
	public List<Ad> getAllEntities(Class<Ad> entityClass) {
		return genDao.getAllEntities(Ad.class);
	}

	@Override
	public void deleteEntityById(Class<Ad> entityClass, long id) {
		genDao.deleteEntityById(Ad.class, id);
	}

	@Override
	public void updateEntity(Ad entity) {
		genDao.updateEntity(entity);
	}

	@Override
	public Ad getEntityById(Class<Ad> entityClass, long id) {
		return genDao.getEntityById(Ad.class, id);
	}

}
