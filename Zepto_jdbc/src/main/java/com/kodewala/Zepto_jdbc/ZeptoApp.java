package com.kodewala.Zepto_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ZeptoApp 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    		Scanner sc=new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbckode", "root", "Nikhil@123");
        
        String query = "insert into student(name, age, rollno, grade) values(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        boolean flag=true;
        while(flag==true)
        {
        		System.out.println("Enter student name: ");
        		pstmt.setString(1, sc.next());
        		System.out.println("Enter student age: ");
            pstmt.setInt(2, sc.nextInt());
    			System.out.println("Enter student rollno: ");
            pstmt.setInt(3, sc.nextInt());
    			System.out.println("Enter student grade: ");
            pstmt.setString(4, sc.next());
            pstmt.addBatch();
            
            System.out.println("Do you want to add student details");
            flag = sc.nextBoolean();
        }
        
        
        pstmt.executeBatch();
        System.out.println("Execution completed");
    }
}
