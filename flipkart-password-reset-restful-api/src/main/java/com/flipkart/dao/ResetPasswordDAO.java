package com.flipkart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flipkart.entity.PasswordLog;
import com.flipkart.entity.Users;
import com.flipkart.exception.EmailNotFoundException;
import com.flipkart.exception.PasswordAlreadyExistException;
import com.flipkart.request.ResetPassword;

@Repository
public class ResetPasswordDAO 
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session;
	Transaction txn;

	public PasswordLog getPasswordLog(String currentEmail)
	{
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		
		String hql = "SELECT userId FROM Users WHERE email = :email";

		Integer currentUserId = (Integer) session.createQuery(hql).setParameter("email", currentEmail).uniqueResult();

		if(currentUserId==null)
		{
			throw new EmailNotFoundException("Email id does not exists..");
		}
		
		String logHql = "FROM PasswordLog WHERE userId = :uid";
		
		PasswordLog passwordLog = (PasswordLog) session.createQuery(logHql)
				.setParameter("uid", currentUserId).uniqueResult();
		
		return passwordLog;
	}
	
	public String updatePassword(String newPassword,PasswordLog passwordLog)
	{
		passwordLog.setOldestPassword(passwordLog.getOldPassword());
        passwordLog.setOldPassword(passwordLog.getCurrentPassword());
        passwordLog.setCurrentPassword(newPassword);

        session.update(passwordLog);
        
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
