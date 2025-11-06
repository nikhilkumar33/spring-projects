package com.kodewala.updatingquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateQuery 
{
    public static void main( String[] args )
    {
    		try {
    			
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbckode", "root", "Nikhil@123");
    			
    			Statement stmt = con.createStatement();
    			String read = "select * from student";
    			ResultSet rs = stmt.executeQuery(read);
    			while(rs.next())
    			{
    				System.out.println(rs.getString(1)+" | "+rs.getInt(2)+" | "+rs.getInt(3)+" | "+rs.getString(4));
    			}
    			String query = "update student set age=33 where name='Chimpu'";
    			int count = stmt.executeUpdate(query);
    			System.out.println("Number of rows effect: "+count);
    			
    			ResultSet result = stmt.executeQuery(read);

    			while(result.next())
    			{
    				System.out.println(result.getString(1)+" | "+result.getInt(2)+" | "+result.getInt(3)+" | "+result.getString(4));
    			}
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
}
