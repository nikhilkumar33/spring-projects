package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.pojo.Order;
import com.kodewala.pojo.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Order order = (Order) applicationContext.getBean("order");
        
        System.out.println(order.getOrderId()+" | "+order.getItemName()+" | "+order.getStatus());
    
    }
}
