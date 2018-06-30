package pl.coderslab.service;

import java.util.List;

import pl.coderslab.dao.Role;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;

public interface SpecificService {
	
	public void saveUserWithRoles(User user, Role[] roles);
	
	public void deleteUserByUsernameWithRoles(String username);
	
	public User getUserByUsername(String username);
	
	public List<Ad> getAllCurrentAds();
	
	public List<Ad> getAllAdsByUserId(Long id);
	
	public void deleteAdById(long id);

}
