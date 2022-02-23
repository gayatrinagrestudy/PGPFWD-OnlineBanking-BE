package com.simplilearn.capstone.project.login.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recipient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String name;
    
    private String email;
    
    private String phone;
    
    private String accountNumber;
    
    private String remark;
    
    private String bankCode;
    
    private String payeeAccount;
    
    private String amountCredited;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDate;
    
    @Transient
    private String amountTransfer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public String getAmountCredited() {
		return amountCredited;
	}

	public void setAmountCredited(String amountCredited) {
		this.amountCredited = amountCredited;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public String getAmountTransfer() {
		return amountTransfer;
	}

	public void setAmountTransfer(String amountTransfer) {
		this.amountTransfer = amountTransfer;
	}
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
