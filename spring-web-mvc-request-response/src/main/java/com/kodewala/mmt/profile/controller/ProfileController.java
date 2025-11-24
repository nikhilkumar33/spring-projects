package com.kodewala.mmt.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodewala.mmt.profile.bean.UserProfile;

@Controller
public class ProfileController
{
	@GetMapping("/showProfilePage")
	public String showProfileCreatePage()
	{
		System.out.println("Inside showProfileCreatePage()........ ");
		return "profile";
	}
	
	@PostMapping("/createProfile")
	public String createUserProfile(@ModelAttribute UserProfile userProfile, Model model)
	{
		System.out.println("First name: "+userProfile.getFirstName());
		System.out.println("Last name: "+userProfile.getLastName());
		System.out.println("Email Id: "+userProfile.getEmail());
		System.out.println("Mobile: "+userProfile.getMobile());
		
		String userId = generateUserId(userProfile.getFirstName(),userProfile.getMobile());
		System.out.println("User id: "+userId);
		model.addAttribute("userId",userId);
		
		return "profile-success";
	}
	
	public static String generateUserId(String firstName, String mobile) {
	    if(firstName == null || firstName.isEmpty() || mobile == null || mobile.length() < 4) {
	        throw new IllegalArgumentException("Invalid input");
	    }

	    // take lowercase for uniformity
	    String namePart = firstName.trim().toLowerCase();

	    // last 4 digits of mobile
	    String mobilePart = mobile.substring(mobile.length() - 4);

	    return namePart + mobilePart;
	}

}
