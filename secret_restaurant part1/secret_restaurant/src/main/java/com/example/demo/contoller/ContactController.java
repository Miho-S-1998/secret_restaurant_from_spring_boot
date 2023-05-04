package com.example.demo.contoller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	
	@GetMapping("/contact")
	public String contact(Authentication loginUser,Model model) {
		model.addAttribute("username",loginUser.getName());
		return "contact";
	}
	
	@GetMapping("/result")
		public String result(Authentication loginUser,Model model) {
		model.addAttribute("username",loginUser.getName());
			return "result";
		}

}
