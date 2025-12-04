package com.flipkart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flipkart.entity.PasswordLog;
import com.flipkart.entity.Users;

@Repository
public class RegisterUserDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public int createUser(Users users)
	{

		System.out.println("Inside createUser........");
		Session session  = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();
		
		Integer userId = (Integer) session.save(users);
		
		PasswordLog passwordLog = new PasswordLog();
		passwordLog.setUserId(userId);
		passwordLog.setCurrentPassword(users.getPassword());
		session.save(passwordLog);
		tnx.commit();
		
		return userId;
		
	}
}
