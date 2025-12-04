package com.kodewala.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController 
{
	@GetMapping("/showCreateProfile")
	public String showUserProfilePage()
	{
		return "profile";
	}
}
