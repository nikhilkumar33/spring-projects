package com.zepto.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController 
{
	@GetMapping("showLogin")
	public ResponseEntity<String> showLoginPage()
	{
		System.out.println("Request received....");
		return ResponseEntity.ok("Request received..!");
	}

}
