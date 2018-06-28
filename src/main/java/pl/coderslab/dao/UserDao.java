package pl.coderslab.dao;

import pl.coderslab.entity.User;

public interface UserDao {
	
	public void saveUserWithRole(User user, Role role);
	
	public User getUserByUsername(String username);
	

}
