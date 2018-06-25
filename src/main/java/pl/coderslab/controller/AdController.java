package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Ad;
import pl.coderslab.service.MyService;

@Controller
@RequestMapping("/ad")
public class AdController {

	@Autowired
	MyService myService;

	@RequestMapping("/delete/{id}")
	public String deleteAd(@PathVariable("id") long id) {
		myService.deleteAdById(id);
		return "redirect:/user";
	}

	@RequestMapping("/edit/{id}")
	public String editAd(@PathVariable("id") long id, Model model) {
		Ad thisAd = myService.getAdById(id);
		model.addAttribute("ad", thisAd);
		return "ad-edit-form";
	}

}
