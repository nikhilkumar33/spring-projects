package com.kodewala.myntra_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyntraApp 
{
    public static void main( String[] args )
    {
    		//loading driver
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			
    			//establish connection
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbckode","root" , "Nikhil@123");
    			
    			//create statement
    			Statement stmt = con.createStatement();
    		
    			String query = "create table student(name varchar(200), age int, rollno int, grade varchar(5))";
    			
    			//execute query
    			stmt.execute(query);
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    }
}
