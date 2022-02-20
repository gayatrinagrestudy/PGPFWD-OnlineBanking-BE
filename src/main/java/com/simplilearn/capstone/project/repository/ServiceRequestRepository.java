package com.simplilearn.capstone.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.capstone.project.login.model.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository <ServiceRequest, Long>{
	
	
	@Query("SELECT sreq FROM ServiceRequest sreq LEFT JOIN Account accnt ON (sreq.accountNumber = accnt.accountNumber) "
			+ "WHERE sreq.accountNumber = :acctNum")
	public List<ServiceRequest> findServiceReqsByAccountNumber(String acctNum);

}
