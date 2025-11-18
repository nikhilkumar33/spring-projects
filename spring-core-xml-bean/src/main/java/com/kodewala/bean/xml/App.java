package com.kodewala.bean.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("com\\kodewala\\bean\\xml\\resources\\SpringCore.xml");
        Student stud = (Student) context.getBean("student");
        System.out.println(stud.getRollNo()+" | "+stud.getName()+" | "+stud.getRollNo());
    }
}
