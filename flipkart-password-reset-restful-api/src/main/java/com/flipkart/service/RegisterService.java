package com.flipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.dao.RegisterUserDAO;
import com.flipkart.entity.Users;
import com.flipkart.request.UserInfo;

@Service
public class RegisterService 
{
	@Autowired
	RegisterUserDAO registerUserDAO;
	
	public int registerUserService(UserInfo userInfo)
	{
		System.out.println("Inside register service...");
		
		Users users = new Users();
		users.setFirstName(userInfo.getFirstName());
		users.setLastName(userInfo.getLastName());
		users.setEmail(userInfo.getEmail());
		users.setMobile(userInfo.getMobile());
		users.setPassword(userInfo.getPassword());
		
		return registerUserDAO.createUser(users);
	}
}
