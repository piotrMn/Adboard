package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.User;

public interface UserDao {
	
	
	public void saveUserWithRole(User user, Role role);
	
	public User getUserById(long id);
	
	public User getUserByUsername(String username);
	
	

}
