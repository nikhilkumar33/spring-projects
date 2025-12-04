package com.kodewala.amazon.profile.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodewala.amazon.entity.UserProfile;
import com.kodewala.amazon.hibernate.config.ConnectHibernate;

@Controller
public class ReSellerLoginController
{
	List<UserProfile> al;
	String name;
	
	@RequestMapping("/showProfilePage")
	public String showProfilePage()
	{
		return "profile";
	}
	
	@PostMapping("/createProfile")
	public String createReSellerProfile(@ModelAttribute UserProfile userProfile, Model model)
	{
		ConnectHibernate connect = new ConnectHibernate();
		Session session = connect.getHibernateConnection();
		Transaction txn = session.beginTransaction();
		session.save(userProfile);
		txn.commit();
		
		al = new ArrayList<UserProfile>();
		al.add(userProfile);
		System.out.println(al);
		name=userProfile.getFirstName();
		
		String userId = generateUserId(userProfile.getFirstName(),userProfile.getMobile());
		model.addAttribute("userId", userId);
		
		return "profile-success";
	}
	
	public String generateUserId(String firstName, String mobile)
	{
		String firstFour = firstName.substring(0,4).toLowerCase();
		String lastFour = mobile.substring(mobile.length() - 4);
		return firstFour+lastFour;
	}
	
	@GetMapping("/showLoginPage")
	public String showLoginPage()
	{
		return "login";
	}
	
	@PostMapping("/validateLogin")
	public String validateLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model)
	{
		boolean result = validateUser(email, password);
		if(result) {
			model.addAttribute("name",name);
			return "amazon-reseller-home";
		}
		else {
			return "login-fail";
		}
	}
	
	public boolean validateUser(String email, String password)
	{
		UserProfile userProfile =  al.get(0);
		String dbEmail = userProfile.getEmail();
		String dbPassword = userProfile.getPassword();
		if(dbEmail.equals(email) && dbPassword.equals(password))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	@RequestMapping("/home")
	public String viewHomePage(Model model)
	{
		model.addAttribute("name",name);
		return "amazon-reseller-home";
	}

}
