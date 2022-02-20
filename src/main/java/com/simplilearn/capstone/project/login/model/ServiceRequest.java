package com.simplilearn.capstone.project.login.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
	
	private String accountNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestedDated;
	
	@Enumerated
	private RequestStatus reqStatus;
	
	private String reqDescription;
	
	private int chequeBookPages;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getRequestedDated() {
		return requestedDated;
	}

	public void setRequestedDated(Date requestedDated) {
		this.requestedDated = requestedDated;
	}

	public RequestStatus getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(RequestStatus reqStatus) {
		this.reqStatus = reqStatus;
	}

	public String getReqDescription() {
		return reqDescription;
	}

	public void setReqDescription(String reqDescription) {
		this.reqDescription = reqDescription;
	}

	public int getChequeBookPages() {
		return chequeBookPages;
	}

	public void setChequeBookPages(int chequeBookPages) {
		this.chequeBookPages = chequeBookPages;
	}
	
}
