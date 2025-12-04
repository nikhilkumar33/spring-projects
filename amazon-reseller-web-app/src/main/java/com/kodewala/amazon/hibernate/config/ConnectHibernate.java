package com.kodewala.amazon.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectHibernate
{
	public Session getHibernateConnection()
	{
		Configuration config = new Configuration();
		config.configure("\\com\\kodewala\\amazon\\hibernate\\config\\hibernate-cfg.xml");
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		return session;
	}
}
