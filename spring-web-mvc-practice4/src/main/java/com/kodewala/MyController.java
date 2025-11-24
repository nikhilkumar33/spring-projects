package com.kodewala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController 
{
	@RequestMapping("/login")
	public String viewLogin()
	{
		System.out.println("MyController.viewLogin()......");
		if(false)
		{
			return "loginFail";
		}
		else {
			return "loginSuccess";
		}
	}
	@RequestMapping("/logout")
	public String logout()
	{
		System.out.println("Successfully logged out");
		return "logoutPage";
	}

}
