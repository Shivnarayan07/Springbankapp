package com.development.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.development.Model.User;
import com.development.Service.UserService;

public class UserController {

	
	
	
	@Autowired
	UserService us;
	
	
	@PostMapping("/reg")
	public User registration(@RequestBody User user) {
		return us.registration(user);
		
	}
	
//	@PostMapping("/create-acc")
//	public String createAccount(@RequestBody User user) {
//		return us.createAccount(user);
//	}
}
