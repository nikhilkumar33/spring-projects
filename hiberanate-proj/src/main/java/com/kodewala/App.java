package com.kodewala;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kodewala.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure("\\com\\kodewala\\config\\hibernate-cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        
        Student st = new Student();
        st.setName("Nikhil");
        st.setGender("Male");
        st.setAge(23);
        st.setMarks(530);
        
        session.save(st);
        
        txn.commit();
        
    }
}
