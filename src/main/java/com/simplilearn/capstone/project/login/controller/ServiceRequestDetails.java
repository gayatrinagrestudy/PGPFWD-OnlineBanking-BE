package com.simplilearn.capstone.project.login.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<ServiceRequest> getCustomerDetails(@PathVariable String accntNum) {	
		return customUserDetailsService.loadServiceRequests(accntNum);
	}
	
	@PostMapping(value="/sericerequests/create")
	public ResponseEntity<ServiceRequest> createUser(@RequestBody ServiceRequest serviceRequestDetails)
	{
		ServiceRequest returnValue = customUserDetailsService.createServiceRequest(serviceRequestDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	@RequestMapping("/accts")
	public Set<String> getSerReqAccnts() {	
		return customUserDetailsService.loadAllUniqueAccnt();
	}
	
	

}
