package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.Ad;

public interface AdDao {
	
	public List<Ad> getAllCurrentAds();
	
	public List<Ad> getAllAdsByUserId(long id);
	
	public void deleteAdById(long id);
	
}
