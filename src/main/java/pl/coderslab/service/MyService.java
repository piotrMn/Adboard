package pl.coderslab.service;

import java.util.List;

import pl.coderslab.dao.Role;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;

public interface MyService {
	
	public void saveUserWithRole(User user, Role role);
	
	public User getUserById(long id);
	
	public User getUserByUsername(String username);
	
	public void saveAd(Ad ad);
	
	public List<Ad> getAllCurrentAds();
	
	public List<Ad> getAllAdsByUserId(Long id);
	
	public void deleteAdById(long id);
	
	public Ad getAdById(long id);
	
	public void updateAd(Ad ad);
	

}
