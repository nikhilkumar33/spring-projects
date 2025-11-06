package com.kodewala.spring_core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    		String context = "resources\\applicationContext.xml";
    		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(context);
    	
    		Account account = (Account) applicationContext.getBean("acc");
    		
    		System.out.println(account.getAccountNumber()+" | "+account.getType()+" | "+account.getIfsc());
    }
}
