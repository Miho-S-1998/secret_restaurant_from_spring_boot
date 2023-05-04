package com.example.demo.contoller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

@Controller
public class HomeController {
	
	private final CommentRepository repository;
	
	public HomeController(CommentRepository repository) {
		this.repository=repository;
	}
	
	@GetMapping("/home")
	public String home1(Authentication loginUser,Model model) {
		model.addAttribute("username",loginUser.getName());
		return "home";
	}
	
	@PostMapping("/home")
	public String home(Authentication loginUser,Model model) {
		model.addAttribute("username",loginUser.getName());
		return "home";
	}
	
	@GetMapping("/menu")
	public String menu(Authentication loginUser,Model model) {
		model.addAttribute("username",loginUser.getName());
		return "menu";
	}
	
	@GetMapping("/news")
	public String news(Authentication loginUser,Model model) {
		model.addAttribute("username",loginUser.getName());
		return "news";
	}
	
	@GetMapping("/master")
	public String master( Authentication loginUser,Comment comment,BindingResult result,Model model) {
		model.addAttribute("username",loginUser.getName());
		model.addAttribute("comments", repository.findAll());
		return "master";
	}
	
	@PostMapping("/add")
	public String addComment(@Validated @ModelAttribute Comment comment,BindingResult result,Model model) {
		model.addAttribute("comment",repository.findAll());
		if(result.hasErrors()) {
			return "master";
		}
		repository.save(comment);
		return "redirect:/master";
	}
	
	@GetMapping("/profile")
	public String profile(Authentication loginUser,Model model) {
		model.addAttribute("username", loginUser.getName());
		model.addAttribute("authority",loginUser.getAuthorities());
		return "profile";
	}
	
}
