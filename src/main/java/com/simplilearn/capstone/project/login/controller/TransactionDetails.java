package com.simplilearn.capstone.project.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.project.login.model.Transactions;
import com.simplilearn.capstone.project.login.service.CustomUserDetailsService;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*")
public class TransactionDetails {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@RequestMapping("/account/{accntNum}")
	public List<Transactions> getCustomerDetails(@PathVariable String accntNum) {	
		return customUserDetailsService.loadUserTxns(accntNum);
	}

}
