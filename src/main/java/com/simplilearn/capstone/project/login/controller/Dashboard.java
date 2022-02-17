package com.simplilearn.capstone.project.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.project.login.model.Account;
import com.simplilearn.capstone.project.login.model.CustomeUserDetails;
import com.simplilearn.capstone.project.login.model.Customer;
import com.simplilearn.capstone.project.login.model.User;
import com.simplilearn.capstone.project.login.service.CustomUserDetailsService;
import com.simplilearn.capstone.project.repository.CustomerDetailsRepository;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class Dashboard {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	

	
	@RequestMapping("/users1/{username}")
	public CustomeUserDetails getUsers1(@PathVariable String username) {	
		return (CustomeUserDetails) customUserDetailsService.loadUserByUsername(username);
	}
	
	@RequestMapping("/users/{loginid}")
	public List<Customer> getCustomerDetails(@PathVariable String loginid) {	
		return customUserDetailsService.loadUserByLoginId(loginid);
	}
	
	
	@RequestMapping("/users/accsummary/{username}")
	public List<Account> getAccSummary(@PathVariable String username) {	
		return customUserDetailsService.loadUserAccount(username);
	}

}
