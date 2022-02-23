package com.simplilearn.capstone.project.login.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class Home {
	
	@RequestMapping("/welcome")
	public String welcome() {
		
		return "Welcome !";
	}
	
	

}
