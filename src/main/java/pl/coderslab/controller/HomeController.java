package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Ad;
import pl.coderslab.service.SpecificService;

@Controller
@RequestMapping("")
public class HomeController {
	
	@Autowired
	SpecificService specificService;
	
	@RequestMapping("")
	public String showHome(Model model) {
		List<Ad> currentAds = specificService.getAllCurrentAds();
		model.addAttribute("ads", currentAds);
		return "home";
	}

}
