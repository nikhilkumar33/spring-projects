package com.kodewala.swiggy.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwiggyLoginController
{
	@RequestMapping("/showLogin")
	public String showLoginPage()
	{
		return "loginPage";
	}
}
