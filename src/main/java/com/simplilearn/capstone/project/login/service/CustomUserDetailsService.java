package com.simplilearn.capstone.project.login.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.simplilearn.capstone.project.login.model.Account;
import com.simplilearn.capstone.project.login.model.AdminData;
import com.simplilearn.capstone.project.login.model.CustomeUserDetails;
import com.simplilearn.capstone.project.login.model.Customer;
import com.simplilearn.capstone.project.login.model.Recipient;
import com.simplilearn.capstone.project.login.model.ServiceRequest;
import com.simplilearn.capstone.project.login.model.Transactions;
import com.simplilearn.capstone.project.login.model.User;
import com.simplilearn.capstone.project.repository.AccountRepository;
import com.simplilearn.capstone.project.repository.AdminRepository;
import com.simplilearn.capstone.project.repository.CustomerDetailsRepository;
import com.simplilearn.capstone.project.repository.RecipientRepository;
import com.simplilearn.capstone.project.repository.ServiceRequestRepository;
import com.simplilearn.capstone.project.repository.TransactionRepository;
import com.simplilearn.capstone.project.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;
	
	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	
	@Autowired
	private RecipientRepository recipientRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		final User user = userRepository.findByUsername(username);	
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found !");
		}
		else 
			return new CustomeUserDetails(user);
	}
	
	public List<Customer> loadUserByLoginId(String loginid)
			throws UsernameNotFoundException {
		List<Customer> customer = customerDetailsRepository.findByLoginId(loginid);	
		if(customer==null) {
			throw new UsernameNotFoundException("User Not Found !");
		}
		else 
			return customer;
	}
	
	public List<Account> loadUserAccount(String username)
			throws UsernameNotFoundException {		
		final User user = userRepository.findByUsername(username);	
		List<Account> accountList = accountRepository.findByUser(user);
		return accountList;
	}
	
	public List<Transactions> loadUserTxns(String accountNumber)
			throws UsernameNotFoundException {		
		List<Transactions> txnList = accountRepository.findTxnListByAccountNumber(accountNumber);
		return txnList;
	}
	
	public List<Recipient> loadRecipientOfPayer(String accountNumber)
			throws UsernameNotFoundException {		
		List<Recipient> recpList = recipientRepository.findRecipientByPayee(accountNumber);
		return recpList;
	}
	
	public List<ServiceRequest> loadServiceRequests(String accountNumber)
			throws UsernameNotFoundException {		
		List<ServiceRequest> recpList = serviceRequestRepository.findServiceReqsByAccountNumber(accountNumber);
		return recpList;
	}
	
	public ServiceRequest createServiceRequest(ServiceRequest requestDetails) {
		String result = requestDetails.getAccountNumber().replaceAll("^\"|\"$", "");
		requestDetails.setAccountNumber(result);
		ServiceRequest requestDetailsReturn = serviceRequestRepository.save(requestDetails);
 		return requestDetailsReturn;
	}
	

	public Set<String> loadAllUniqueAccnt()
			throws UsernameNotFoundException {		
		List<Account> reqList = accountRepository.findAll();
		Set<String> set = new HashSet<>(reqList.size());
		reqList.stream().filter(req -> set.add(req.getAccountNumber())).collect(Collectors.toList());
		return set;
	}

	public void amoutTransfered(Recipient recipientDetails) {
		Long totalAmount = 0L;
		Long totalAmtDeducted = 0L;
		Long amtTobeDeducted =0L;
		String acctn = recipientDetails.getAccountNumber().replaceAll("^\"|\"$", "");
		recipientDetails.setAccountNumber(acctn);
		Recipient recipient = loadRecipientBuAccNum(recipientDetails.getAccountNumber());
		if(recipient.getAmountCredited()==null) {
			totalAmount = Long.valueOf(recipientDetails.getAmountCredited());
		} else {
			totalAmount = Long.valueOf(recipient.getAmountCredited())+Long.valueOf(recipientDetails.getAmountTransfer());
		}
		amtTobeDeducted = Long.valueOf(recipientDetails.getAmountTransfer());
		recipientRepository.updateRecipient(recipientDetails.getAccountNumber(),totalAmount.toString(),recipientDetails.getTransferDate());
		Account account = accountRepository.findByAccountNumber(recipientDetails.getPayeeAccount());
		totalAmtDeducted = account.getAccountBalance().longValue() - amtTobeDeducted;
		Transactions txn = new Transactions();
		txn.setAccount(account);
		txn.setRemark(recipientDetails.getRemark());
		txn.setWithdraw(BigDecimal.valueOf(amtTobeDeducted));
		txn.setTxnDate(recipientDetails.getTransferDate());
		transactionRepository.save(txn);
		accountRepository.updateAccountForTransfer(BigDecimal.valueOf(totalAmtDeducted),recipientDetails.getPayeeAccount());
	}
	
	public Recipient loadRecipientBuAccNum(String accountNumber)
			throws UsernameNotFoundException {		
		Recipient recipient = recipientRepository.findRecipientByAccount(accountNumber);
		return recipient;
	}
	
	public List<AdminData> loadAllUserDetails() {
		return adminRepository.findAll();
	}
	
	public void UpdateAccountStatus(String status,String accountNum) {
		 adminRepository.updateUserAcctStatus(status,accountNum);
		
	}
	
}
