package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.Ad;

public interface AdDao {
	
	public void saveAd(Ad ad);
	
	public List<Ad> getAllCurrentAds();
	
	public List<Ad> getAllAdsByUserId(Long id);
	
	public void deleteAdById(long id);
	
	public Ad getAdById(long id);
	
	public void updateAd(Ad ad);
	

}
