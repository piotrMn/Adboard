package pl.coderslab.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.User;
import pl.coderslab.service.GenericService;
import pl.coderslab.service.SpecificService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	SpecificService specificService;

	@Autowired
	GenericService<Ad> adService;

	@Autowired
	GenericService<User> userService;
	
	@Autowired
	GenericService<Category> catService;

	@RequestMapping("")
	public String showHomePageUser(Model model, HttpServletRequest request) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (username != null) {
			User thisUser = specificService.getUserByUsername(username);
			if (thisUser != null) {
				List<Ad> theAds = specificService.getAllAdsByUserId(thisUser.getId());
				request.setAttribute("loggedUserId", thisUser.getId());
				model.addAttribute("myAds", theAds);
			}
		}
		return "home-user";
	}

	@RequestMapping("/delete-ad/{id}")
	public String deleteAd(@PathVariable("id") long id) {
		adService.deleteEntityById(Ad.class, id);
		return "redirect:/user";
	}

	@GetMapping("/edit-ad/{id}")
	public String editAd(@PathVariable("id") long id, Model model, HttpServletRequest request) {
		Ad thisAd = adService.getEntityById(Ad.class, id);
		request.getSession().setAttribute("categories", thisAd.getCategories());
		model.addAttribute("thisAd", thisAd);
		return "ad-edit-form";
	}

	@PostMapping("/edit-ad/{id}")
	public String editAdPost(@Valid Ad thisAd, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "ad-edit-form";
		}
		List<Category> categories = (List<Category>) request.getSession().getAttribute("categories");
		thisAd.setCategories(categories);
		adService.updateEntity(thisAd);
		request.getSession().removeAttribute("categories");
		return "redirect:/user";
	}

	@GetMapping("/new-ad")
	public String newAd(Model model) {
		Ad newAd = new Ad();
		model.addAttribute("newAd", newAd);
		return "new-ad-form";
	}

	@PostMapping("/new-ad")
	public String newAdPost(@Valid Ad newAd, BindingResult result) {
		if (result.hasErrors()) {
			return "new-ad-form";
		}
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User thisUser = specificService.getUserByUsername(username);
//		thisUser.getAds().add(newAd);
		newAd.setUser(thisUser);
		newAd.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(30)));
		adService.saveEntity(newAd);
		return "redirect:/user";
	}

	@GetMapping("/delete-user")
	public String deleteUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (username != null) {
			SecurityContextHolder.clearContext();
			specificService.deleteUserByUsernameWithRoles(username);
		}
		return "redirect:/";
	}
	@GetMapping("/my-ads/{id}")
	public String showMyAddsPage(@PathVariable("id") long id, Model model) {
		User thisUser = userService.getEntityById(User.class, id);
//		List<Ad> hisAds = thisUser.getAds();
		List<Ad> hisAds = specificService.getAllAdsByUserId(thisUser.getId());
		model.addAttribute("ads", hisAds);
		return "my-ads";
		
	}
	
	@ModelAttribute("currentAds")
	public List<Ad> getCurrentAds() {
		return specificService.getAllCurrentAds();
	}
	
	@ModelAttribute("allCategories")
	public List<Category> addCategories() {
		List<Category> allCategories = catService.getAllEntities(Category.class);
		Collections.sort(allCategories);
		return allCategories;
	}

}
