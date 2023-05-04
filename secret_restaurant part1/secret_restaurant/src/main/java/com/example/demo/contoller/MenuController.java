package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	@GetMapping("/drink")
	public String drink() {
		return "drink";
	}
	
	@GetMapping("/sandwich")
		public String sandwich() {
			return "sandwich";
		}
	
	@GetMapping("/sweets")
	public String sweets() {
		return "sweets";
	}
	
	@GetMapping("/set")
	public String set() {
		return "set";
	}
	
	@GetMapping("/special")
	public String special() {
		return "special";
	}
	
	@GetMapping("/breakfast")
	public String breakfast() {
		return "breakfast";
	}
	
	@GetMapping("/meal")
	public String meal() {
		return "meal";
	}

}
