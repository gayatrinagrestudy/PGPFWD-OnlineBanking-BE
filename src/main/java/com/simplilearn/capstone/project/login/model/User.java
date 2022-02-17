package com.simplilearn.capstone.project.login.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Component
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String password;
	
	/*
	 * private String firstName;
	 * 
	 * private String lastName;
	 * 
	 * private String email;
	 * 
	 * private int contactNumber;
	 * 
	 * private String bankBranchCode;
	 * 
	 * @Enumerated private Status userStatus;
	 * 
	 * private Date lastUpdated;
	 * 
	 * @Temporal(TemporalType.TIMESTAMP) private Date lastLogin;
	 * 
	 * @Embedded private UserAddress address;
	 * 
	 * @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL) private List<Account> account;
	 * 
	 * @OneToMany(mappedBy = "user") private List<Recipient> recipientList;
	 */
    
    private boolean isAdminRole;
    
    private boolean isUserRole;
    
	public User() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public Status getUserStatus() { return userStatus; }
	 * 
	 * public void setUserStatus(Status userStatus) { this.userStatus = userStatus;
	 * }
	 * 
	 * public Date getLastLogin() { return lastLogin; }
	 * 
	 * public void setLastLogin(Date lastLogin) { this.lastLogin = lastLogin; }
	 * 
	 * public List<Account> getAccount() { return account; }
	 * 
	 * public void setAccount(List<Account> account) { this.account = account; }
	 * 
	 * 
	 * public String getFirstName() { return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public int getContactNumber() { return contactNumber; }
	 * 
	 * public void setContactNumber(int contactNumber) { this.contactNumber =
	 * contactNumber; }
	 * 
	 * 
	 * public UserAddress getAddress() { return address; }
	 * 
	 * public void setAddress(UserAddress address) { this.address = address; }
	 * 
	 * public Date getLastUpdated() { return lastUpdated; }
	 * 
	 * public void setLastUpdated(Date lastUpdated) { this.lastUpdated =
	 * lastUpdated; }
	 */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public List<Recipient> getRecipientList() { return recipientList; }
	 * 
	 * public void setRecipientList(List<Recipient> recipientList) {
	 * this.recipientList = recipientList; }
	 * 
	 * public String getBankBranchCode() { return bankBranchCode; }
	 * 
	 * public void setBankBranchCode(String bankBranchCode) { this.bankBranchCode =
	 * bankBranchCode; }
	 */

	public boolean isAdminRole() {
		return isAdminRole;
	}

	public void setAdminRole(boolean isAdminRole) {
		this.isAdminRole = isAdminRole;
	}

	public boolean isUserRole() {
		return isUserRole;
	}

	public void setUserRole(boolean isUserRole) {
		this.isUserRole = isUserRole;
	}

}
