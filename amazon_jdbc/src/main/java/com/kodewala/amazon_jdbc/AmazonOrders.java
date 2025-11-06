package com.kodewala.amazon_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AmazonOrders 
{
	public void insertOrderDetails(Scanner sc, Connection con) throws SQLException
	{
		String query = "insert into orders(orderid,itemname,price,status) values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		System.out.println("Enter orderid: ");
		pstmt.setInt(1, sc.nextInt());
		sc.nextLine();
		System.out.println("Enter itemname: ");
		pstmt.setString(2, sc.nextLine());
		System.out.println("Enter price: ");
		pstmt.setInt(3, sc.nextInt());
		sc.nextLine();
		System.out.println("Enter order status: ");
		pstmt.setString(4, sc.nextLine());
		
		int count = pstmt.executeUpdate();
		System.out.println("Rows inserted : "+count);
	}
	public void updateOrderDetails(Scanner sc, Connection con) throws SQLException
	{
		String query = "update orders set status=? where orderid = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		System.out.println("Enter orderid: ");
		pstmt.setInt(2, sc.nextInt());
		sc.nextLine();
		System.out.println("Enter the order status: ");
		pstmt.setString(1, sc.nextLine());
		
		int count = pstmt.executeUpdate();
		System.out.println("Rows updated : "+count);
	}
	public void deleteOrderDetails(Scanner sc, Connection con) throws SQLException
	{
		String query = "delete from orders where orderid=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		System.out.println("Enter the orderid to remove the row: ");
		pstmt.setInt(1, sc.nextInt());
		int count = pstmt.executeUpdate();
		System.out.println("Rows deleted : "+count);
	}
	public void readOrderTable(Scanner sc, Connection con) throws SQLException
	{
		String query = "select * from orders where orderid=? ";
		PreparedStatement pstmt = con.prepareStatement(query);
		System.out.println("Enter id to view the row: ");
		pstmt.setInt(1, sc.nextInt());
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3)+" | "+rs.getString(4));
		}
	}
	public void readTable(Scanner sc, Connection con) throws SQLException
	{
		String query = "select * from orders";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3)+" | "+rs.getString(4));
		}
	}
}
