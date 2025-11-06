package com.kodewala.spring_core_bean_xml_proj3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources\\applicationContext.xml");
    		Employee employee = (Employee) applicationContext.getBean("emp");
    		System.out.println(employee.getEmpId()+" | "+employee.getEmpName()+" | "+employee.getEmpSalary());
    }
}
