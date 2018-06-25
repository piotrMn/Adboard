package pl.coderslab.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;
import pl.coderslab.service.MyService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	MyService myService;

	@RequestMapping("")
	public String showHomePageUser(Principal principal, Model model) {
		String username = principal.getName();
		User thisUser = null;
		List<Ad> theAds = new ArrayList<>();
		if (username != null) {
			thisUser = myService.getUserByUsername(username);
		}
		if (thisUser != null) {
			theAds = myService.getAllAdsByUserId(thisUser.getId());
		}
		model.addAttribute("ads", theAds);
		return "home-user";
	}

}
