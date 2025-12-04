package com.flipkart.payment.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flipkart.payment.entity.Payment;
import com.flipkart.payment.exception.PaymentFailedException;

@Repository
public class PaymentDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public int confirmPayment(Payment payment)
	{
		System.out.println("PaymentDAO: confirmPayment: "+payment.getStatus());
		if(payment.getStatus().equals("PAID"))
		{
			Session session  = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			Integer paymentId = (Integer) session.save(payment);
			txn.commit();
			
			System.out.println("PaymentDAO: confirmPayment: PaymentId: "+paymentId);
			return paymentId;
		}
		else {
			
			throw new PaymentFailedException("Payment failed...");
		}
	}
}
