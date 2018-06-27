package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Category;
import pl.coderslab.service.GeneralService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	GeneralService<Category> generalService;

	@GetMapping("/new")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "new-category-form";
	}

	@PostMapping("/new")
	public String addCategoryPost(@ModelAttribute("category") Category category) {
		generalService.saveEntity(category);
		return "redirect:/admin";
	}

	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") long id) {
		generalService.deleteEntityById(Category.class, id);
		return "redirect:/admin";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") long id, Model model) {
		Category thisCategory = generalService.getEntityById(Category.class, id);
		model.addAttribute("category", thisCategory);
		return "edit-category-form";
	}
	
	@PostMapping("/edit/{id}")
	public String editCategoryPost(@ModelAttribute("category") Category category) {
		generalService.updateEntity(category);
		return "redirect:/admin";
	}
	

}
