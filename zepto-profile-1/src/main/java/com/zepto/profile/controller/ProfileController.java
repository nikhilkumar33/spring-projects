package com.zepto.profile.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zepto.profile.request.ProfileInfo;

@RestController
public class ProfileController 
{

	@PostMapping("createProfile")
	public ResponseEntity<String> createProfile(@RequestBody ProfileInfo profileInfo)
	{
		System.out.println(profileInfo.getName());
		return ResponseEntity.ok("Profile created successfully....");
	}
}
