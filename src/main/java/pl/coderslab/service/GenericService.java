package pl.coderslab.service;

import java.util.List;

public interface GenericService<T> {
	
	public void saveEntity(T entity);
	
	public List<T> getAllEntities(Class<T> entityClass);
	
	public void deleteEntityById(Class<T> entityClass, long id);
	
	public void updateEntity(T entity);
	
	public T getEntityById(Class<T> entityClass, long id);
	

}
