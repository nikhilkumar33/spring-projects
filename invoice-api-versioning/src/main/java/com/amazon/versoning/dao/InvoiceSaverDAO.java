package com.amazon.versoning.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazon.versoning.entity.Invoice;

@Repository
public class InvoiceSaverDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public int createInvoice(Invoice invoice) {
		
		Session session=sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer invoiceId = (Integer)session.save(invoice);
		txn.commit();
		return invoiceId;
	}

}
