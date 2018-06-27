package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;
import pl.coderslab.service.GeneralService;
import pl.coderslab.service.SpecificService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	SpecificService specificService;
	
	@Autowired
	GeneralService<User> generalService;

	@RequestMapping("")
	public String showHomePageUser(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User thisUser = specificService.getUserByUsername(username);
		List<Ad> theAds = specificService.getAllAdsByUserId(thisUser.getId());
		model.addAttribute("ads", theAds);
		return "home-user";
	}
	

}
