package pl.coderslab.dao;

import pl.coderslab.entity.User;

public interface UserDao {
	
	public void saveUserWithRoles(User user, Role[] roles);
	
	public void deleteUserByUsernameWithRoles(String username);
	
	public User getUserByUsername(String username);
}
