package com.development.Service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.Model.Account;
import com.development.Model.User;
import com.development.Repository.AccountRepository;
import com.development.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	  UserRepository ud;
	  @Autowired
	  AccountRepository ad;
	
	public User registration (User user) {
		List<User>usr=ud.findByPanOrAdharOrEmail(user.getPan(),user.getAdhar(),user.getEmail());
		
		return usr.isEmpty()?ud.save(user):new User();
	}
	
	public String createAccount(User user) {
		List<User>usr=ud.findByPanOrAdharOrEmail(user.getPan(),
												 user.getAdhar(),
												 user.getEmail());

		if(usr.isEmpty()) {
			ud.save(user);
			
			Random rand = new Random();
			
			int acc_Num= rand.nextInt(1000);
			Account acc = new Account();
			acc.setAccountNumber(acc_Num);
			acc.setBalance(0L);
			acc.setUser(user);
			ad.save(acc);
			return "Your account has been created";
			}
		else {
			return "You can't create an account";
		}
		
	}
}
