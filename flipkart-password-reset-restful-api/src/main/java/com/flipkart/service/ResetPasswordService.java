package com.flipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.dao.ResetPasswordDAO;
import com.flipkart.request.ResetPassword;

@Service
public class ResetPasswordService 
{
	@Autowired
	ResetPasswordDAO resetPasswordDAO;
	
	public String resetPassService(ResetPassword resetPassword)
	{
		return resetPasswordDAO.resetPassword(resetPassword);
	}
}
