package com.kodewala.bms.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodewala.bms.profile.bean.UserProfile;

@Controller
public class ProfileController 
{
	@RequestMapping("/showProfilePage")
	public String showProfilePage()
	{
		return "profile";
	}
	
	@PostMapping("/createProfile")
	public String createUserProfile(@ModelAttribute UserProfile userProfile, Model model)
	{
		System.out.println("User name: "+userProfile.getFirstName()+" "+userProfile.getLastName());
		System.out.println("Email id: "+userProfile.getEmail());
		System.out.println("Mobile no: "+userProfile.getMobile());
		System.out.println("Password is: "+userProfile.getPassword());
		String userId = generateUserId(userProfile.getFirstName(),userProfile.getMobile());
		
		model.addAttribute("userId", userId);
		return "profile-success";
	}
	
	public static String generateUserId(String firstName, String mobile)
	{
		String firstFour = firstName.substring(0, 4).toLowerCase();  
        String lastFour = mobile.substring(mobile.length() - 4);
        return firstFour+lastFour;
	}
}
