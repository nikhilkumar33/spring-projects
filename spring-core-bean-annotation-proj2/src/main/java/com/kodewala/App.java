package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.bean.Student;

public class App 
{
    public static void main( String[] args )
    {
    		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    		
    		Student stud = context.getBean(Student.class);
    		
    		System.out.println("Id: "+stud.getStudentId()+" Name: "+stud.getName()+" Grade: "+stud.getGrade());
    }
}
