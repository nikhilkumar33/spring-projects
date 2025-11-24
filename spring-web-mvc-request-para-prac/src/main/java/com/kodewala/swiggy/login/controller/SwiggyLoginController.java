package com.kodewala.swiggy.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SwiggyLoginController
{
	@RequestMapping("/showLogin")
	public String showLoginPage()
	{
		System.out.println("Inside Show Login page...");
		return "loginPage";
	}
	
	@RequestMapping("/validateLogin")
	public String validateLogin(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		System.out.println("Inside Validate Login...");

		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		return "login-success";
	}
	
}
