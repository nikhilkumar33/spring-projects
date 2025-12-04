package com.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.request.ResetPassword;
import com.flipkart.service.ResetPasswordService;

@RestController
public class PasswordManagementController
{
	@Autowired
	ResetPasswordService resetPasswordService;	
	
	
	@PostMapping("resetPassword")
	public ResponseEntity resetPassword(@RequestBody ResetPassword resetPassword)
	{
		System.out.println(resetPassword.getEmail());
		
		String result = resetPasswordService.resetPassService(resetPassword);
		
		return ResponseEntity.ok(result);
	}
}
