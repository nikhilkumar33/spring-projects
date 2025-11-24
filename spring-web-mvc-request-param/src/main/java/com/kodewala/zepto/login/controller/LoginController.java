package com.kodewala.zepto.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController 
{
	@RequestMapping("/showLogin")
	public String showLogin()
	{
		System.out.println("Showlogin()............");
		
		return "loginPage";
	}
	
	@RequestMapping("/validateLogin")
	public String validateLogin(@RequestParam("userName") String userName, @RequestParam("password") String password)
	{
		System.out.println("ValidateLogin()............");
		System.out.println("User name: "+userName);
		System.out.println("User password: "+password);

		return "login-success";
	}
	
}
