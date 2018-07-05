package pl.coderslab.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.dao.Role;
import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.User;
import pl.coderslab.service.GenericService;
import pl.coderslab.service.SpecificService;

@Controller
@RequestMapping("")
public class HomeController {

	@Autowired
	SpecificService specificService;

	@Autowired
	GenericService<Category> catService;
	
	@RequestMapping("")
	public String showHome() {
		return "home";
	}

	@RequestMapping("/login")
	public String showLoginPage() {
		return "login-form";
	}

	@RequestMapping("/access-denied")
	public String showAccesDeniedPage() {
		return "access-denied";
	}

	@GetMapping("/signup")
	public String showSignupPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup-form";
	}

	@PostMapping("/signup")
	public String showSignupPagePost(@Valid User user, BindingResult result,
			@RequestParam("password2") String password2, Model model) {
		if (result.hasErrors()) {
			return "signup-form";
		}
		if (user.getPassword().equals(password2)) {
			user.setPassword("{bcrypt}" + BCrypt.hashpw(password2, BCrypt.gensalt()));
			user.setEnabled(1);
			specificService.saveUserWithRoles(user, new Role[] { Role.ROLE_USER });
		} else {
			model.addAttribute("error", "mismatch");
			return "signup-form";
		}
		return "redirect:/user";
	}
	

	@ModelAttribute("currentAds")
	public List<Ad> getCurrentAds() {
		List<Ad> allAds = specificService.getAllCurrentAds();
		return allAds;
	}

	@ModelAttribute("allCategories")
	public List<Category> addCategories() {
		List<Category> allCategories = catService.getAllEntities(Category.class);
		Collections.sort(allCategories);
		return allCategories;
	}

}
