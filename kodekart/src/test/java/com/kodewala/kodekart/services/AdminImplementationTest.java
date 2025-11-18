package com.kodewala.kodekart.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class AdminImplementationTest {

    private AdminImplementation admin;
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
 
    @Before
    public void setUp() {
        admin = new AdminImplementation();
        con = mock(Connection.class);
        pstmt = mock(PreparedStatement.class);
        rs = mock(ResultSet.class);

        // Replace Scanner with a mocked Scanner
        admin.sc = mock(Scanner.class);
    }

    // -----------------------------------------------------------------
    // 1. adminHome()
    // -----------------------------------------------------------------
    @Test
    public void testAdminHomeReturnsValidChoice() {
        when(admin.sc.nextInt()).thenReturn(3); // selecting "Update Product"
        when(admin.sc.nextLine()).thenReturn("");

        int result = admin.adminHome();
        assertEquals(3, result);
    }

    // -----------------------------------------------------------------
    // 2. addProduct()
    // -----------------------------------------------------------------
    @Test
    public void testAddProductSuccess() throws Exception {

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(admin.sc.nextLine())
                .thenReturn("Mobile")   // name
                .thenReturn("Electronics") // category
                .thenReturn("Good phone")  // description
                .thenReturn("no"); // stop adding

        when(admin.sc.nextInt())
                .thenReturn(10000) // price
                .thenReturn(10);   // quantity

        when(pstmt.executeBatch()).thenReturn(new int[]{1});

        int result = admin.addProduct(con);
        assertEquals(1, result);
    }

    // -----------------------------------------------------------------
    // 3. updateProducts()
    // -----------------------------------------------------------------
    @Test
    public void testUpdateProductsSuccess() throws Exception {

        when(con.prepareStatement("select * from products")).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        when(rs.next()).thenReturn(false); // no products printed

        // For updating
        when(admin.sc.nextInt()).thenReturn(1); // update name
        when(admin.sc.nextLine())
                .thenReturn("") 
                .thenReturn("New Name") // new updated name
                .thenReturn("no"); // stop update

        PreparedStatement updateStmt = mock(PreparedStatement.class);
        when(con.prepareStatement(startsWith("update products set name"))).thenReturn(updateStmt);

        int result = admin.updateProducts(con);
        assertEquals(1, result);
    }

    // -----------------------------------------------------------------
    // 4. deleteProduct()
    // -----------------------------------------------------------------
    @Test
    public void testDeleteProductSuccess() throws Exception {

        when(con.prepareStatement("select * from products")).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(false);

        PreparedStatement delStmt = mock(PreparedStatement.class);
        when(con.prepareStatement("delete from products where id= ?")).thenReturn(delStmt);
        
        when(admin.sc.nextInt()).thenReturn(5); // product id
        when(delStmt.executeUpdate()).thenReturn(1);

        int result = admin.deleteProduct(con);
        assertEquals(1, result);
    }

    // -----------------------------------------------------------------
    // 5. fetchProducts()
    // -----------------------------------------------------------------
    @Test
    public void testFetchProductsSuccess() throws Exception {

        when(con.prepareStatement("select * from products")).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        when(rs.next()).thenReturn(false); // No rows

        int result = admin.fetchProducts(con);
        assertEquals(1, result);
    }

    // -----------------------------------------------------------------
    // 6. fetchAllOrders()
    // -----------------------------------------------------------------
    @Test
    public void testFetchAllOrdersSuccess() throws Exception {

        PreparedStatement orderStmt = mock(PreparedStatement.class);
        PreparedStatement itemStmt = mock(PreparedStatement.class);
        PreparedStatement productStmt = mock(PreparedStatement.class);

        ResultSet orderRes = mock(ResultSet.class);
        ResultSet itemRes = mock(ResultSet.class);
        ResultSet prodRes = mock(ResultSet.class);

        // Mock queries
        when(con.prepareStatement("select * from orders")).thenReturn(orderStmt);
        when(orderStmt.executeQuery()).thenReturn(orderRes);

        when(orderRes.next()).thenReturn(true).thenReturn(false);
        when(orderRes.getInt(1)).thenReturn(1); // order_id
        when(orderRes.getInt(2)).thenReturn(10); // user_id
        when(orderRes.getDate(3)).thenReturn(new Date(System.currentTimeMillis()));
        when(orderRes.getInt(4)).thenReturn(5000); // total amount

        when(con.prepareStatement("select * from order_items where order_id=?")).thenReturn(itemStmt);
        when(itemStmt.executeQuery()).thenReturn(itemRes);
        when(itemRes.next()).thenReturn(true).thenReturn(false);
        when(itemRes.getInt(3)).thenReturn(7); // productId
        when(itemRes.getInt(4)).thenReturn(2); // qty

        when(con.prepareStatement("select * from products where id=?")).thenReturn(productStmt);
        when(productStmt.executeQuery()).thenReturn(prodRes);

        when(prodRes.next()).thenReturn(true);
        when(prodRes.getString(2)).thenReturn("iPhone");
        when(prodRes.getInt(4)).thenReturn(50000);

        int result = admin.fetchAllOrders(con);

        assertEquals(1, result);
    }
}
