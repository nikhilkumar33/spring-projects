package com.flipkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.dao.ResetPasswordDAO;
import com.flipkart.entity.PasswordLog;
import com.flipkart.exception.PasswordAlreadyExistException;
import com.flipkart.request.ResetPassword;

@Service
public class ResetPasswordServiceImplementation implements ResetPasswordService 
{
	@Autowired
	ResetPasswordDAO resetPasswordDAO;

	@Override
	public String resetPassService(ResetPassword resetPassword) 
	{
		System.out.println("Inside ResetPasswordService....");
		String currentEmail = resetPassword.getEmail();
		
		PasswordLog passwordLog = resetPasswordDAO.getPasswordLog(currentEmail);

		String newPassword = resetPassword.getNewPassword();
		String currentPassword = passwordLog.getCurrentPassword();
		String oldPassword = passwordLog.getOldPassword();
		String oldestPassword = passwordLog.getOldestPassword();

		if (newPassword.equalsIgnoreCase(currentPassword)) 
		{
			throw new PasswordAlreadyExistException("Your new password is same as your current password");
		} 
		else
		{
			if (oldPassword == null)
			{
				return resetPasswordDAO.updatePassword(newPassword, passwordLog);
			}
			else if (newPassword.equalsIgnoreCase(oldPassword)) 
			{
				throw new PasswordAlreadyExistException("Your Password not be your previous 3 password");
			} 
			else
			{
				if (oldestPassword == null) 
				{
					return resetPasswordDAO.updatePassword(newPassword, passwordLog);
				}
				else if (newPassword.equalsIgnoreCase(oldestPassword)) 
				{
					throw new PasswordAlreadyExistException("Your Password not be your previous 3 password");
				} 
				else
				{
					return resetPasswordDAO.updatePassword(newPassword, passwordLog);
				}
			}
		}
	}
}
