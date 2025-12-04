package com.flipkart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flipkart.entity.PasswordLog;
import com.flipkart.entity.Users;
import com.flipkart.request.ResetPassword;

@Repository
public class ResetPasswordDAO 
{
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ResetPasswordDAO resetPasswordDAO;
	
	Session session;
	Transaction txn;

	public String resetPassword(ResetPassword resetPassword) 
	{
		System.out.println("Inside ResetPasswordDAO....");
		session = sessionFactory.openSession();
		txn = session.beginTransaction();

		String currentEmail = resetPassword.getEmail();
		//fetching the userid of that email
		String hql = "SELECT userId FROM Users WHERE email = :email";

		Integer currentUserId = (Integer) session.createQuery(hql).setParameter("email", currentEmail).uniqueResult();

		//fetching the passwordlog which is mapped with userid
		String logHql = "FROM PasswordLog WHERE userId = :uid";
		
		PasswordLog passwordLog = (PasswordLog) session.createQuery(logHql)
				.setParameter("uid", currentUserId).uniqueResult();
		
		String newPassword = resetPassword.getNewPassword();
		String currentPassword = passwordLog.getCurrentPassword();
		String oldPassword = passwordLog.getOldPassword();
		String oldestPassword = passwordLog.getOldestPassword();

		//checking the new password is same as the current password if not same go inside
		if(newPassword.equalsIgnoreCase(currentPassword)) 
		{
			return "Your new password is same as your current password";
		}
		else {
			//checking the old password is null 
			if(oldPassword==null)
			{
				return resetPasswordDAO.swapPassword(newPassword, passwordLog);
			}
			//checking the oldpassword is same or not if not same go inside
			else if(newPassword.equalsIgnoreCase(oldPassword))
			{
				return "Your Password not be your previous 3 password";
			}
			else {
				//checking the oldest password is null 
				if(oldestPassword==null)
				{
					return resetPasswordDAO.swapPassword(newPassword, passwordLog);
				}
				//checking the oldestpassword is same or not if not same go inside
				else if(newPassword.equalsIgnoreCase(oldestPassword))
				{
					return "Your Password not be your previous 3 password";
				}
				else
				{
					return resetPasswordDAO.swapPassword(newPassword, passwordLog);
				}
			}
		}
	}
	
	public String swapPassword(String newPassword,PasswordLog passwordLog)
	{
		//swaping the newpassword with old passwords
		passwordLog.setOldestPassword(passwordLog.getOldPassword());
        passwordLog.setOldPassword(passwordLog.getCurrentPassword());
        passwordLog.setCurrentPassword(newPassword);

        session.update(passwordLog);
        
        //getting the user by userid and update the newpassword
        String hql = "FROM Users WHERE userId = :userId";
        Users user = (Users) session.createQuery(hql)
                .setParameter("userId", passwordLog.getUserId())
                .uniqueResult();
        user.setPassword(newPassword);
        session.update(user);

        txn.commit();
        return "Password reset successful";
	}
	
}
