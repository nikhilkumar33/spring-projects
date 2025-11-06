package com.kodewala.amazontransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ) throws ClassNotFoundException, SQLException 
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazonjdbc","root","Nikhil@123");
		String name=null;
		try {
			con.setAutoCommit(false);
			String paymentQuery = "update payment set status=? where paymentid=?";
			PreparedStatement pstmt = con.prepareStatement(paymentQuery);
			pstmt.setString(1, "paid");
			pstmt.setInt(2, 55);
			int count = pstmt.executeUpdate();
			if(count >0)	{
				System.out.println("Payment is done..");
			}else {
				System.out.println("Payment is failed..");
			}
			
			String orderQuery = "update orders set status=? where orderid= ?";
			pstmt = con.prepareStatement(orderQuery);
			pstmt.setString(1, "paid");
			pstmt.setInt(2, 11);
			int updateCount = pstmt.executeUpdate();
			if(updateCount >0)	{
				System.out.println("Order is placed..");
			}else {
				System.out.println("Order is failed.. try again.. ");
			}
			//name.length();
			con.commit();
		}
		catch(Exception e)	{
			con.rollback();
			System.out.println("Order not placed try again..");
			e.printStackTrace();
		}
    }
}
