package pl.coderslab.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Ad;
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

	@RequestMapping("")
	public String showHomePageUser(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (username != null) {
			User thisUser = specificService.getUserByUsername(username);
			if (thisUser != null) {
				List<Ad> theAds = specificService.getAllAdsByUserId(thisUser.getId());
				model.addAttribute("ads", theAds);
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
	public String editAd(@PathVariable("id") long id, Model model) {
		Ad thisAd = adService.getEntityById(Ad.class, id);
		model.addAttribute("ad", thisAd);
		return "ad-edit-form";
	}

	@PostMapping("/edit-ad")
	public String editAdPost(@ModelAttribute("ad") Ad ad) {
		adService.updateEntity(ad);
		return "redirect:/user";
	}

	@GetMapping("/new-ad")
	public String newAd(Model model) {
		Ad ad = new Ad();
		model.addAttribute("ad", ad);
		return "new-ad-form";
	}

	@PostMapping("/new-ad")
	public String newAdPost(@ModelAttribute("ad") Ad newAd) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User thisUser = specificService.getUserByUsername(username);
		thisUser.getAds().add(newAd);
		newAd.setUser(thisUser);
		newAd.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(30)));
		adService.saveEntity(newAd);
		return "redirect:/user";
	}

	@GetMapping("/delete-user")
	public String deleteUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User thisUser = specificService.getUserByUsername(username);
		if(thisUser != null) {
			SecurityContextHolder.clearContext();
			userService.deleteEntityById(User.class, thisUser.getId());
		}
		return "redirect:/";
	}

}
