package com.simplilearn.capstone.project.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.project.login.model.Recipient;
import com.simplilearn.capstone.project.login.model.ServiceRequest;
import com.simplilearn.capstone.project.login.model.Transactions;
import com.simplilearn.capstone.project.login.service.CustomUserDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class RecipientDetails {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@PostMapping(value="/recipient/amtcredited")
	public ResponseEntity<Recipient> getAmtTransfered(@RequestBody Recipient recipient) {	
		customUserDetailsService.amoutTransfered(recipient);
		Recipient returnValue = customUserDetailsService.loadRecipientBuAccNum(recipient.getAccountNumber());
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	@GetMapping(value="/recipient/{accntNum}")
	public List<Recipient> getRecipients(@PathVariable String accntNum) {	
		List<Recipient> returnValue = customUserDetailsService.loadRecipientOfPayer(accntNum);
		return returnValue;
	}
	
}
