package com.amazon.invoice.swiggy_hibernate_payment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amazon.invoice.swiggy_hibernate_payment.entity.Payment;

public class App 
{
    public static void main( String[] args )
    {
    	String path = "com\\amazon\\invoice\\swiggy_hibernate_payment\\config\\hibernate-cfg.xml";
        Configuration config = new Configuration().configure(path);
        
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        
        Payment payment = new Payment();
        payment.setAmount(15000);
        payment.setStatus("PAID");
        payment.setSendBy("Nikhil");
        payment.setDescription("Payment successful");
        session.save(payment);
        txn.commit();
    }
}
