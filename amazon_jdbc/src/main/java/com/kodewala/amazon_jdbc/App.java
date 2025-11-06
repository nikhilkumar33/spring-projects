package com.kodewala.amazon_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    		Scanner sc = new Scanner(System.in);
    		Connection con = null;
    		try 
    		{
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazonjdbc","root","Nikhil@123");
			
    			AmazonOrders amazonOrders = new AmazonOrders();
    			boolean flag = true;
    			while(flag==true)
    			{
    				System.out.println("Enter 1 for insert row, 2 for update status, 3 for delete row, 4 for read single row, 5 for read entire table");
    				int choice = sc.nextInt();
    				switch(choice)
    				{
    						case 1: amazonOrders.insertOrderDetails(sc, con);
    								break;
    						case 2: amazonOrders.updateOrderDetails(sc, con);
									break;
    						case 3: amazonOrders.deleteOrderDetails(sc, con);
									break;
    						case 4: amazonOrders.readOrderTable(sc, con);
    								break;
    						case 5: amazonOrders.readTable(sc, con);
    								break;
    						default:
    							flag=false;
    							System.out.println("Invalid choice.. Exit..");
    				}
    			}
    		} 
    		catch (ClassNotFoundException | SQLException e) 
    		{
				e.printStackTrace();
		}
    }
}
