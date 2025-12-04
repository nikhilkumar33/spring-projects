package com.kodewala.zepto.order.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kodewala.zepto.order.entity.Orders;

@Repository
public class OrderDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public int createOrder(Orders orders)
	{
		System.out.println("OrderDAO: item : "+orders.getItem());
		Session session = sessionFactory.openSession();
		Transaction txn =  session.beginTransaction();
		Integer orderId = (Integer) session.save(orders);
		txn.commit();
		
		return orderId;
	}
}
