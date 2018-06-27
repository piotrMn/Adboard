package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.dao.AdDao;
import pl.coderslab.dao.Role;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;

@Service
public class SpecificServiceImpl implements SpecificService {

	@Autowired
	UserDao userDao;

	@Autowired
	AdDao adDao;

	@Override
	public void saveUserWithRole(User user, Role role) {
		userDao.saveUserWithRole(user, role);
	}

	@Override
	public List<Ad> getAllCurrentAds() {
		return adDao.getAllCurrentAds();
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public List<Ad> getAllAdsByUserId(Long id) {
		return adDao.getAllAdsByUserId(id);
	}


}
