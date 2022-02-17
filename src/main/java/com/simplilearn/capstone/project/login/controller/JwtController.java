package com.simplilearn.capstone.project.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.project.jwt.helper.JwtUtil;
import com.simplilearn.capstone.project.login.model.JwtRequest;
import com.simplilearn.capstone.project.login.model.JwtResponse;
import com.simplilearn.capstone.project.login.service.CustomUserDetailsService;

@CrossOrigin(origins = "*") 
@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
    
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/token", method= RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println("jwtRequest " +jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found...");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad credential...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("generateToken User - " );
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("generateToken " +token);
		
		
		return ResponseEntity.ok(new JwtResponse(token));
		
		
	}
}
