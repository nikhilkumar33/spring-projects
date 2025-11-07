package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.config.SpringConfig;
import com.kodewala.pojo.Account;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context= new AnnotationConfigApplicationContext(SpringConfig.class);
       Account account= context.getBean(Account.class);
       System.out.println(account);
    }
}
