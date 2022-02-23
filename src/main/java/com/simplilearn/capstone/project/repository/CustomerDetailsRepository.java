package com.simplilearn.capstone.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.capstone.project.login.model.CustomeUserDetails;
import com.simplilearn.capstone.project.login.model.Customer;
import com.simplilearn.capstone.project.login.model.User;


public interface CustomerDetailsRepository extends JpaRepository<Customer, Long>{
	
	public List<Customer> findByLoginId(String username);

}
