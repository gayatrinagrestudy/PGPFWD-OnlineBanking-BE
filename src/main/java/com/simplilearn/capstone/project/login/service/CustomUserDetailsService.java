package com.simplilearn.capstone.project.login.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simplilearn.capstone.project.login.model.Account;
import com.simplilearn.capstone.project.login.model.CustomeUserDetails;
import com.simplilearn.capstone.project.login.model.Customer;
import com.simplilearn.capstone.project.login.model.Recipient;
import com.simplilearn.capstone.project.login.model.ServiceRequest;
import com.simplilearn.capstone.project.login.model.Transactions;
import com.simplilearn.capstone.project.login.model.User;
import com.simplilearn.capstone.project.repository.AccountRepository;
import com.simplilearn.capstone.project.repository.CustomerDetailsRepository;
import com.simplilearn.capstone.project.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		final User user = userRepository.findByUsername(username);	
		System.out.println("CustomUserDetailsService User - " +user);
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found !");
		}
		else 
			return new CustomeUserDetails(user);
	}
	
	public List<Customer> loadUserByLoginId(String loginid)
			throws UsernameNotFoundException {
		List<Customer> customer = customerDetailsRepository.findByLoginId(loginid);	
		System.out.println("CustomUserDetailsService User - " +customer);
		if(customer==null) {
			throw new UsernameNotFoundException("User Not Found !");
		}
		else 
			return customer;
	}
	
	public List<Account> loadUserAccount(String username)
			throws UsernameNotFoundException {		
		final User user = userRepository.findByUsername(username);	
		List<Account> accountList = accountRepository.findByUser(user);
		return accountList;
	}
	
	public List<Transactions> loadUserTxns(Long accountNumber)
			throws UsernameNotFoundException {		
		List<Transactions> txnList = accountRepository.findTxnListByAccountNumber(accountNumber);
		return txnList;
	}
	
	public List<Recipient> loadRecipient(Long accountNumber)
			throws UsernameNotFoundException {		
		List<Recipient> recpList = accountRepository.findRecipientByAccountNumber(accountNumber);
		return recpList;
	}
	
	public List<ServiceRequest> loadServiceRequests(Long accountNumber)
			throws UsernameNotFoundException {		
		List<ServiceRequest> recpList = accountRepository.findServiceReqsByAccountNumber(accountNumber);
		return recpList;
	}
	
	

}
