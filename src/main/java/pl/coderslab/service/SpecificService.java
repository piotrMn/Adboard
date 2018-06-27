package pl.coderslab.service;

import java.util.List;

import pl.coderslab.dao.Role;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;

public interface SpecificService {
	
	public void saveUserWithRole(User user, Role role);
	
	public User getUserByUsername(String username);
	
	public List<Ad> getAllCurrentAds();
	
	public List<Ad> getAllAdsByUserId(Long id);
	
	
	

}
