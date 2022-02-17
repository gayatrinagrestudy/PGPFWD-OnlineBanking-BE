package com.simplilearn.capstone.project.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simplilearn.capstone.project.login.model.ServiceRequest;
import com.simplilearn.capstone.project.login.service.CustomUserDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class ServiceRequestDetails {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@RequestMapping("/sericerequests/{accntNum}")
	public List<ServiceRequest> getCustomerDetails(@PathVariable long accntNum) {	
		return customUserDetailsService.loadServiceRequests(accntNum);
	}

}
