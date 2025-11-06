package com.kodewala.insertingquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class InsertingQuery 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        //load the driver
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		//get the connection
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbckode", "root", "Nikhil@123");
    
    		//create statement
    		Statement stmt = con.createStatement();
    		
    		//execute query
    		String query = "insert into student(name,age,rollno,grade) value('Cherry',21,5588,'B')";
    		
    		stmt.execute(query);
    		
    		String read = "select * from student";
    		ResultSet rs = stmt.executeQuery(read);
    		while(rs.next())
    		{
    			System.out.println(rs.getString(1)+" | "+rs.getInt(2)+" | "+rs.getInt(3)+" | "+rs.getString(4));
    		}
    		
    
    }
}
