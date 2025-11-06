package com.kodewala.flipkart;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FlipkartApp 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkartapp", "root", "Nikhil@123");
    		
    		String query="select * from cart where quantity = ? and price > ?";
    		PreparedStatement stmt = con.prepareStatement(query);
    		stmt.setInt(1, 2);
    		stmt.setBigDecimal(2, new BigDecimal(70000.00));
    		
    		ResultSet rs = stmt.executeQuery();
    		
    		while(rs.next())
    		{
    			System.out.println("Item Name: "+rs.getString(1)+" , Quantity: "+rs.getInt(2)+" , Price: "+rs.getBigDecimal(3));
    		}
    		
    		
    }
}
