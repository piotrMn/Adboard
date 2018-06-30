package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Ad;
import pl.coderslab.entity.Category;
import pl.coderslab.service.GenericService;
import pl.coderslab.service.SpecificService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	GenericService<Category> catService;
	
	@Autowired
	GenericService<Ad> adService;
	
	@Autowired
	SpecificService specificService;
	
	@RequestMapping("")
	public String showAdminPage() {
		return "admin";
	}
	
	@RequestMapping("/manage")
	public String showAdManagementPage() {
		return "ad-management";
	}
	
	@GetMapping("/new-category")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "new-category-form";
	}

	@PostMapping("/new-category")
	public String addCategoryPost(@Valid Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "new-category-form";
		}
		catService.saveEntity(category);
		return "redirect:/admin";
	}

	@GetMapping("/delete-category/{id}")
	public String deleteCategory(@PathVariable("id") long id) {
		catService.deleteEntityById(Category.class, id);
		return "redirect:/admin";
	}
	
	@GetMapping("/delete-ad/{id}")
	public String deleteAd(@PathVariable("id") long id) {
		specificService.deleteAdById(id);
		return "redirect:/admin/manage";
	}
	
	@GetMapping("/edit-category/{id}")
	public String editCategory(@PathVariable("id") long id, Model model) {
		Category thisCategory = catService.getEntityById(Category.class, id);
		model.addAttribute("category", thisCategory);
		return "category-edit-form";
	}
	
	@PostMapping("/edit-category/{id}")
	public String editCategoryPost(@ModelAttribute("category") Category category) {
		catService.updateEntity(category);
		return "redirect:/admin";
	}
	
	@GetMapping("/edit-ad/{id}")
	public String showAdEditPage(@PathVariable("id") long id, Model model, HttpServletRequest request) {
		Ad thisAd = adService.getEntityById(Ad.class, id);
		request.getSession().setAttribute("categories", thisAd.getCategories());
		model.addAttribute("thisAd", thisAd);
		return "ad-edit-form-admin";
	}
	
	@PostMapping("/edit-ad/{id}")
	public String showAdEditPagePost(@Valid Ad thisAd, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "ad-edit-form-admin";
		}
		List<Category> cateogries = (List<Category>) request.getSession().getAttribute("categories");
		thisAd.setCategories(cateogries);
		adService.updateEntity(thisAd);
		request.getSession().removeAttribute("categories");
		return "redirect:/admin/manage";
	}
	
	@GetMapping("/assign-category/{id}")
	public String addCategory(@PathVariable("id") long id, Model model) {
		Ad thisAd = adService.getEntityById(Ad.class, id);
		model.addAttribute("thisAd", thisAd);
		List<Category> allCategories = catService.getAllEntities(Category.class);
		model.addAttribute("allCategories", allCategories);
		return "assign-category-form";
	}
	
	@PostMapping("/assign-category/{id}")
	public String addCategoryPost(@PathVariable("id") long id, @RequestParam("categories") List<String> categoriesIdRaw, Model model, HttpServletRequest request) {
		if(categoriesIdRaw.size() > 3) {
			request.setAttribute("error", "toomany");
			return "assign-category-form";
		}
		Ad thisAd = adService.getEntityById(Ad.class, id);
		List<Category> categories = new ArrayList<>();
		for(String catId : categoriesIdRaw) {
			Long thisId = Long.parseLong(catId);
			Category thisCat = catService.getEntityById(Category.class, thisId);
			thisCat.getAds().add(thisAd);
			categories.add(thisCat);
		}
		thisAd.getCategories().clear();
		thisAd.getCategories().addAll(categories);
		adService.updateEntity(thisAd);
		return "redirect:/admin/manage";
	}
	
	@ModelAttribute("allCategories")
	public List<Category> addCategories() {
		return catService.getAllEntities(Category.class);
	}
	
	@ModelAttribute("allAds")
	public List<Ad> addAds(){
		return adService.getAllEntities(Ad.class);
	}
	
}
