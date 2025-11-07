package com.kodewala.spring_core_bean_java_proj2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.spring_core_bean_java_proj2.bean.FamilyStar;
import com.kodewala.spring_core_bean_java_proj2.bean.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
    		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    		FamilyStar family =(FamilyStar) context.getBean("family");
    		System.out.println(family);
    }
}
