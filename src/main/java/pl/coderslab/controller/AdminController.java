package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;
import pl.coderslab.service.AdServiceImpl;
import pl.coderslab.service.CatServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CatServiceImpl catService;
	
	@Autowired
	AdServiceImpl adService;
	
	@RequestMapping("")
	public String showAdminPage() {
		return "admin";
	}
	
	@RequestMapping("/manage")
	public String showAdManagementPage() {
		return "ad-management";
	}
	
	@GetMapping("/adedit/{id}")
	public String showAdEditPage(@PathVariable("id") long id, Model model) {
		Ad thisAd = adService.getEntityById(Ad.class, id);
		model.addAttribute("ad", thisAd);
		return "ad-edit-form-admin";
	}
	
	@PostMapping("/adedit")
	public String showAdEditPagePost(@ModelAttribute("ad") Ad ad) {
		adService.updateEntity(ad);
		return "redirect:/admin/manage";
	}
	
	@GetMapping("/addcat/{id}")
	public String addCategory(@PathVariable("id") long id, Model model) {
		Ad thisAd = adService.getEntityById(Ad.class, id);
		model.addAttribute("ad", thisAd);
		List<Category> categories = catService.getAllEntities(Category.class);
		model.addAttribute("categories", categories);
		return "ad-category-form";
	}
	
	@PostMapping("/addcat/{id}")
	public String addCategoryPost(@RequestParam("categories") List<Category> categories, @PathVariable("id") long id) {
		Ad thisAd = adService.getEntityById(Ad.class, id);
		thisAd.getCategories().addAll(categories);
		for(Category cat : categories) {
			cat.getAds().add(thisAd);
		}
		adService.updateEntity(thisAd);
		return "redirect:/admin/manage";
	}
	
	
	@ModelAttribute("categories")
	public List<Category> addCategories() {
		return catService.getAllEntities(Category.class);
	}
	
	@ModelAttribute("ads")
	public List<Ad> addAds(){
		return adService.getAllEntities(Ad.class);
	}
	
}
