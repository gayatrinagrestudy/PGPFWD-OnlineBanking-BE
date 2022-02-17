package com.simplilearn.capstone.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.capstone.project.login.model.Account;
import com.simplilearn.capstone.project.login.model.Recipient;
import com.simplilearn.capstone.project.login.model.ServiceRequest;
import com.simplilearn.capstone.project.login.model.Transactions;
import com.simplilearn.capstone.project.login.model.User;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public List<Account> findByUser(User user);
	
	@Query("SELECT txn FROM Transactions txn LEFT JOIN Account accnt ON (txn.account.accountNumber = accnt.accountNumber) "
			+ "WHERE accnt.accountNumber = :acctNum")
	public List<Transactions> findTxnListByAccountNumber(Long acctNum);
	
	@Query("SELECT rec FROM Recipient rec JOIN Account accnt ON (rec.accountNumber = accnt.accountNumber) "
			+ "WHERE rec.accountNumber = :acctNum")
	public List<Recipient> findRecipientByAccountNumber(Long acctNum);
	
	@Query("SELECT sreq FROM ServiceRequest sreq JOIN Account accnt ON (sreq.accountNumber = accnt.accountNumber) "
			+ "WHERE sreq.accountNumber = :acctNum")
	public List<ServiceRequest> findServiceReqsByAccountNumber(Long acctNum);
	

}
