package com.zepto.payment.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zepto.payment.entity.Payment;
import com.zepto.payment.exception.PaymentFailedException;

@Repository
public class PaymentDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public int confirmPayment(Payment payment) 
	{
		System.out.println("Inside PaymentDAO....");
		Session session  = sessionFactory.openSession();
		Transaction txn =  session.beginTransaction();
		Integer paymentId = (Integer)session.save(payment);
		txn.commit();
		
		System.out.println("Payment Confirmed...."+paymentId);
		boolean flag = true;
		if(flag)
		{
			throw new PaymentFailedException("Payment failed...");
		} 
		else {
			return paymentId;
		}
	}
}
