package com.simplilearn.capstone.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.capstone.project.login.model.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Long>{
	
	
	@Query("SELECT rec FROM Recipient rec LEFT JOIN Account accnt ON (rec.payeeAccount = accnt.accountNumber) "
			+ "WHERE rec.payeeAccount = :acctNum")
	public List<Recipient> findRecipientByPayee(String acctNum);
	
	@Query("SELECT rec FROM Recipient rec LEFT JOIN Account accnt ON (rec.accountNumber = accnt.accountNumber) "
			+ "WHERE rec.accountNumber = :acctNum")
	public Recipient findRecipientByAccount(String acctNum);
	
	@Modifying
	@Query("Update Recipient repint set repint.amountCredited =:amount , repint.transferDate =:transferDate "
			+ "WHERE repint.accountNumber = :acctNum")
	public void updateRecipient(String acctNum,String amount, Date transferDate);

}
