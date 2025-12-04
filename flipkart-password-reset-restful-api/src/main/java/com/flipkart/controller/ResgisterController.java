package com.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.request.UserInfo;
import com.flipkart.service.RegisterService;

@RestController
public class ResgisterController 
{
	@Autowired
	RegisterService registerService;
	
	@PostMapping("register")
	public ResponseEntity registerUser(@RequestBody UserInfo userInfo)
	{
		System.out.println("User Info: "+userInfo.getFirstName()+" "+userInfo.getEmail());
		
		int userId = registerService.registerUserService(userInfo);
		
		return ResponseEntity.ok("Register success.. User Id: "+userId);
	}
}
