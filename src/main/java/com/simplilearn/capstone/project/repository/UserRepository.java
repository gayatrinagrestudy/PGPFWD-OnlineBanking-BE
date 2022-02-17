package com.simplilearn.capstone.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.capstone.project.login.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//public List<User> findByUsername(String username);
	public User findByUsername(String username);
	public Optional<User> findById(Long id);

}
