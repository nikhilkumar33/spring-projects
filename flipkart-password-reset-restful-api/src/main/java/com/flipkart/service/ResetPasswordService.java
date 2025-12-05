package com.flipkart.service;

import org.springframework.stereotype.Service;

import com.flipkart.request.ResetPassword;

@Service
public interface ResetPasswordService 
{
	
	String resetPassService(ResetPassword resetPassword);

}
