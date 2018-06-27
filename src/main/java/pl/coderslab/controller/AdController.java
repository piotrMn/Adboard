package pl.coderslab.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.User;
import pl.coderslab.service.GeneralService;
import pl.coderslab.service.SpecificService;

@Controller
@RequestMapping("/ad")
public class AdController {

	@Autowired
	GeneralService<Ad> generalService;
	
	@Autowired
	SpecificService specificService;

	@RequestMapping("/delete/{id}")
	public String deleteAd(@PathVariable("id") long id) {
		generalService.deleteEntityById(Ad.class, id);
		return "redirect:/user";
	}

	@GetMapping("/edit/{id}")
	public String editAd(@PathVariable("id") long id, Model model) {
		Ad thisAd = generalService.getEntityById(Ad.class, id);
		model.addAttribute("ad", thisAd);
		return "ad-edit-form";
	}
	
	@PostMapping("/edit")
	public String editAdPost(@ModelAttribute("ad") Ad ad) {
		generalService.updateEntity(ad);
		return "redirect:/user";
	}
	
	@GetMapping("/new")
	public String newAd(Model model) {
		Ad ad = new Ad();
		model.addAttribute("ad", ad);
		return "new-add-form";
	}
	
	@PostMapping("/new")
	public String newAdPost(@ModelAttribute("ad") Ad newAd) {
		String username =  SecurityContextHolder.getContext().getAuthentication().getName();
		User thisUser = specificService.getUserByUsername(username);
		thisUser.getAds().add(newAd);
		newAd.setUser(thisUser);
		newAd.setExpiryTimestamp(Timestamp.valueOf(LocalDateTime.now().plusDays(30)));
		generalService.saveEntity(newAd);
		return "redirect:/user";
	}
	

}
