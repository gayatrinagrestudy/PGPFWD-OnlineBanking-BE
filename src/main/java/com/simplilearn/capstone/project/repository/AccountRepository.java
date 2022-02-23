package com.simplilearn.capstone.project.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.capstone.project.login.model.Account;
import com.simplilearn.capstone.project.login.model.Recipient;
import com.simplilearn.capstone.project.login.model.ServiceRequest;
import com.simplilearn.capstone.project.login.model.Transactions;
import com.simplilearn.capstone.project.login.model.User;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public List<Account> findByUser(User user);
	
	@Query("SELECT txn FROM Transactions txn LEFT JOIN Account accnt ON (txn.account.accountNumber = accnt.accountNumber) "
			+ "WHERE accnt.accountNumber = :acctNum")
	public List<Transactions> findTxnListByAccountNumber(String acctNum);
	
	public Account findByAccountNumber(String acctNum);
	
	@Modifying
	@Query("Update Account accnt set accnt.accountBalance =:amount WHERE accnt.accountNumber = :acctNum")
	public void updateAccountForTransfer(BigDecimal amount, String acctNum);


	

}
