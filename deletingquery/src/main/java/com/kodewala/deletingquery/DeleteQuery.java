package com.kodewala.deletingquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbckode", "root", "Nikhil@123");
        
        Statement stmt = con.createStatement();
        
        String read = "select * from student";
        ResultSet rs = stmt.executeQuery(read);
        while(rs.next())
        {
        		System.out.println(rs.getString(1)+" | "+rs.getInt(2)+" | "+rs.getInt(3)+" | "+rs.getString(4));
        }
        
        String query = "delete from student where age=33";
        int count = stmt.executeUpdate(query);
        System.out.println("Deleted rows: "+count);
        
        ResultSet rs1 = stmt.executeQuery(read);
        while(rs1.next())
        {
        		System.out.println(rs1.getString(1)+" | "+rs1.getInt(2)+" | "+rs1.getInt(3)+" | "+rs1.getString(4));
        }
    }
}
