package com.simplilearn.capstone.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.capstone.project.login.model.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long>{


}
