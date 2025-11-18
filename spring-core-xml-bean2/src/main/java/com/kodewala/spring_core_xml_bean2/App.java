package com.kodewala.spring_core_xml_bean2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("\\rsources\\config.xml");
        Bank bank = (Bank)context.getBean("bank");
        System.out.println(bank.getAccountNum()+" | "+bank.getAccountType()+" | "+bank.getBranch());
    }
}
