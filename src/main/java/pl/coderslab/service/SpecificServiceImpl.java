package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.dao.AdDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.dao.CommentDao;
import pl.coderslab.dao.Role;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.CommentDTO;
import pl.coderslab.entity.User;

@Service
public class SpecificServiceImpl implements SpecificService {

	@Autowired
	UserDao userDao;

	@Autowired
	AdDao adDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	CategoryDao categoryDao;

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

	@Override
	public void saveUserWithRoles(User user, Role[] roles) {
		userDao.saveUserWithRoles(user, roles);
	}

	@Override
	public void deleteUserByUsernameWithRoles(String username) {
		userDao.deleteUserByUsernameWithRoles(username);
	}

	@Override
	public void deleteAdById(long id) {
		adDao.deleteAdById(id);
	}

	@Override
	public List<Comment> getCommentsByAdId(long id) {
		return commentDao.getCommentsByAdId(id);
	}

	@Override
	public void saveComment(CommentDTO commentDTO) {
		commentDao.saveComment(commentDTO);
	}

	@Override
	public List<Category> getAllCategoriesAlphabetically() {
		return categoryDao.getAllCategoriesAlphabetically();
	}



}
