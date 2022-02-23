package com.simplilearn.capstone.project.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.capstone.project.login.model.AdminData;

public interface AdminRepository extends JpaRepository<AdminData, Long> {

	@Modifying
	@Query("Update AdminData data set data.accountStatus =:status WHERE data.accountNumber = :acctNum")
	public void updateUserAcctStatus(String status, String acctNum);
}
