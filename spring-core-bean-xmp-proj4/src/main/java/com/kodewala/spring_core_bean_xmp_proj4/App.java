package com.kodewala.spring_core_bean_xmp_proj4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources\\applicationContext.xml");
        Order ord1 = (Order) applicationContext.getBean("order1");
        Order ord2 = (Order) applicationContext.getBean("order2");
        
        System.out.println(ord1.getOrderId()+" | "+ord1.getItemName()+" | "+ord1.getStatus());
        System.out.println(ord2.getOrderId()+" | "+ord2.getItemName()+" | "+ord2.getStatus());

    }
}
