package com.development.Service;

import java.util.Optional;

//import org.apache.catalina.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.development.Model.Account;
import com.development.Model.User;
import com.development.Repository.AccountRepository;
import com.development.Repository.UserRepository;

@Service
public class AccountService {

	
	@Autowired
	AccountRepository ad;
	@Autowired
	UserRepository ud;
	
	public Account createAccount(@RequestBody Account account) {
		
		
		return  ad.save(account);
	}



	public Account createAccountAh(Account account,String accountHolderEmail) {
		User user = ud.findByEmail(accountHolderEmail).get();
		Account ac = new Account();
		ac.setAccountNumber(1452);
		ac.setBalance(200L);
		ac.setUser(user);
		
		return ad.save(ac);
	}

	
	public String addBalance(int accountNumber,Long balance) {
		Optional<Account> account = ad.findByAccountNumber(accountNumber);
		if(account.isPresent()) {
			Account ac = account.get();
			Long currentBalance = ac.getBalance();
			Long finalBalance = currentBalance + balance;
			
			ac.setBalance(finalBalance);
			
			ad.save(ac);			//it is used for save as well as update.
			return "Balance has been updated";
		}
		else {
			
			return "Account number is not available";
		}
	}
	
	
	public String checkBalance(int accountNumber) {
		Optional<Account> account = ad.findByAccountNumber(accountNumber);
		
		if(account.isPresent()) {
			return "Your balance is"+ account.get().getBalance();
		}else {
			return "Invalid Account Number..";
		}
//		return (account.isPresent())? "Your balance is "+ account.get()
//.					.getBalance():"Invalid Account Number";
		
	}
	
	
	public String balanceTransfer(int myAccNo,int endUserAccNo,Long ammount) {
		
		Optional<Account> myAccount = ad.findByAccountNumber(myAccNo);
		if(myAccount.isPresent()) {
			Account myAcc = myAccount.get();
			if((boolean) (myAccount.get().getBalance()>= ammount)) {
				Optional<Account> endUserAccount = ad.findByAccountNumber(endUserAccNo );
				if(endUserAccount.isPresent()) {
					Account endUserAcc = endUserAccount.get();
				//	Long currentBalance = myAcc.getBalance();
				//	Long finalBalance = currentBalance - ammount;
				//	myAcc.setBalance(finalBalance);
					
					myAcc.setBalance(myAcc.getBalance()-ammount);
					ad.save(myAcc);
					
				//	Long euBalance = endUserAcc.getBalance();
				//	Long euFinalBalance = euBalance +ammount;
				//	endUserAcc .setBalance(euFinalBalance);
					
					endUserAcc.setBalance(endUserAcc.getBalance()+ammount);
					ad.save(endUserAcc);
					
					return "Amount has been transfered successfully..";
				}else {
					return "End user account numberis not valid..";
				}
				
				
			}else {
				return "Balance is low...";
			}
			
		}else{
			
		}
		return null;
	}	
}
