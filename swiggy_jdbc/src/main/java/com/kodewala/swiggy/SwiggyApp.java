package com.kodewala.swiggy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class SwiggyApp 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbckode", "root", "Nikhil@123");
        
        String query = "insert into orders (orderid, description,quantity,status) values (?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        for(int i=1;i<=100;i++)
        {
        		pstmt.setInt(1,i);
        		pstmt.setString(2, "some description..."+i);
        		pstmt.setInt(3, 3);
        		pstmt.setString(4, "delivered");
        		
        		pstmt.addBatch();
        }
        int[] res = pstmt.executeBatch();
        System.out.println(Arrays.toString(res));
    }
}
