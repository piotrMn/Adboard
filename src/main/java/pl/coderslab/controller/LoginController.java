package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login-form";
		
	}
	
	@RequestMapping("/access-denied")
	public String showAccesDeniedPage() {
		return "access-denied";
	}
	
}
