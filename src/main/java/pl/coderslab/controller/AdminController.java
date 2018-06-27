package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Category;
import pl.coderslab.service.GeneralService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	GeneralService<Category> generalService;
	
	@RequestMapping("")
	public String showAdminPage() {
		return "admin";
	}

	@ModelAttribute("categories")
	public List<Category> addCategories() {
		return generalService.getAllEntities(Category.class);
	}
	
}
