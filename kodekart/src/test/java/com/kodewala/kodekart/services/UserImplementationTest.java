package com.kodewala.kodekart.services;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.*;
import org.mockito.*;

public class UserImplementationTest {

    @Mock private Connection con;
    @Mock private PreparedStatement pstmt;
    @Mock private ResultSet rs;

    private UserImplementation user;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        user = new UserImplementation();
    }

    // ----------------------------------------------------------------------
    // 1. userHome() — with mocked scanner
    // ----------------------------------------------------------------------
    @Test
    public void testUserHomeValidChoice() {
        Scanner mockScanner = new Scanner("3\n");
        user.setScanner(mockScanner);
        int choice = user.userHome();
        assertEquals(3, choice);
    }

    @Test
    public void testUserHomeInvalidThenValid() {
        Scanner mockScanner = new Scanner("10\n2\n");
        user.setScanner(mockScanner);
        int choice = user.userHome();
        assertEquals(2, choice);
    }

    // ----------------------------------------------------------------------
    // 2. viewProducts()
    // ----------------------------------------------------------------------
    @Test
    public void testViewProducts() throws Exception {
        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        when(rs.next()).thenReturn(true, true, false);
        when(rs.getInt(5)).thenReturn(10, 0);  // only first product should print

        user.viewProducts(con);

        verify(con, times(1)).prepareStatement(anyString());
    }

    // ----------------------------------------------------------------------
    // 3. searchProduct()
    // ----------------------------------------------------------------------
    @Test
    public void testSearchProductFound() throws Exception {
        user.setScanner(new Scanner("mobile\n"));

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        when(rs.next()).thenReturn(true, false);
        when(rs.getString(2)).thenReturn("Mobile");
        when(rs.getString(3)).thenReturn("Electronics");

        int result = user.searchProduct(con);

        assertEquals(1, result);
    }

    @Test
    public void testSearchProductNotFound() throws Exception {
        user.setScanner(new Scanner("chair\n"));

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        when(rs.next()).thenReturn(true, false);
        when(rs.getString(2)).thenReturn("Mobile");
        when(rs.getString(3)).thenReturn("Electronics");

        int result = user.searchProduct(con);

        assertEquals(0, result);
    }

    // ----------------------------------------------------------------------
    // 4. addToCart()
    // ----------------------------------------------------------------------
    @Test
    public void testAddToCartSuccess() throws Exception {
        user.setScanner(new Scanner("5\n2\n"));

        PreparedStatement prodCheckStmt = mock(PreparedStatement.class);
        PreparedStatement insertStmt = mock(PreparedStatement.class);
        ResultSet prodRs = mock(ResultSet.class);

        when(con.prepareStatement(startsWith("select id"))).thenReturn(prodCheckStmt);
        when(con.prepareStatement(startsWith("insert"))).thenReturn(insertStmt);

        when(prodCheckStmt.executeQuery()).thenReturn(prodRs);
        when(prodRs.isBeforeFirst()).thenReturn(true);

        when(insertStmt.executeUpdate()).thenReturn(1);

        int result = user.addToCart(con, 10);

        assertEquals(1, result);
    }

    @Test
    public void testAddToCartInvalidProduct() throws Exception {
        user.setScanner(new Scanner("5\n2\n"));

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);
        when(rs.isBeforeFirst()).thenReturn(false);

        int result = user.addToCart(con, 10);

        assertEquals(0, result);
    }

    // ----------------------------------------------------------------------
    // 5. viewCart()
    // ----------------------------------------------------------------------
    @Test
    public void testViewCartEmpty() throws Exception {
        // scanner irrelevant since empty cart returns before menu
        user.setScanner(new Scanner(""));

        when(con.prepareStatement(contains("cart"))).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);
        when(rs.isBeforeFirst()).thenReturn(false);

        int result = user.viewCart(con, 10);

        assertEquals(3, result);
    }

    @Test
    public void testViewCartUserSelectsOption() throws Exception {

        user.setScanner(new Scanner("1\n"));

        PreparedStatement cartStmt = mock(PreparedStatement.class);
        PreparedStatement prodStmt = mock(PreparedStatement.class);

        ResultSet cartRs = mock(ResultSet.class);
        ResultSet prodRs = mock(ResultSet.class);

        when(con.prepareStatement(contains("from cart"))).thenReturn(cartStmt);
        when(con.prepareStatement(contains("from products"))).thenReturn(prodStmt);

        when(cartStmt.executeQuery()).thenReturn(cartRs);
        when(prodStmt.executeQuery()).thenReturn(prodRs);

        // cart result set mock
        when(cartRs.isBeforeFirst()).thenReturn(true);
        when(cartRs.next()).thenReturn(true, false); // only 1 row

        when(cartRs.getInt(3)).thenReturn(2); // product id
        when(cartRs.getInt(4)).thenReturn(3); // quantity

        // product result set mock
        when(prodRs.next()).thenReturn(true, false); // <-- IMPORTANT FIX

        when(prodRs.getString(2)).thenReturn("Mobile");
        when(prodRs.getString(3)).thenReturn("Electronics");
        when(prodRs.getInt(4)).thenReturn(10000);

        int result = user.viewCart(con, 10);

        assertEquals(1, result);
    }


    // ----------------------------------------------------------------------
    // 6. orderItem()
    // ----------------------------------------------------------------------
    @Test
    public void testOrderItemSuccess() throws Exception {

        // Mock all statements
        PreparedStatement cartStmt = mock(PreparedStatement.class);
        PreparedStatement prodStmt = mock(PreparedStatement.class);
        PreparedStatement orderStmt = mock(PreparedStatement.class);
        PreparedStatement itemStmt = mock(PreparedStatement.class);
        PreparedStatement updateStmt = mock(PreparedStatement.class);
        PreparedStatement deleteStmt = mock(PreparedStatement.class);

        // Mock all result sets
        ResultSet cartRs = mock(ResultSet.class);
        ResultSet prodRs = mock(ResultSet.class);
        ResultSet keyRs = mock(ResultSet.class);

        /** ---------------- CART SELECT ---------------- */
        when(con.prepareStatement(startsWith("select * from cart"))).thenReturn(cartStmt);
        when(cartStmt.executeQuery()).thenReturn(cartRs);

        when(cartRs.next()).thenReturn(true, false);  // 1 cart item
        when(cartRs.getInt(1)).thenReturn(100);       // cart id
        when(cartRs.getInt(3)).thenReturn(2);         // product id
        when(cartRs.getInt(4)).thenReturn(3);         // qty

        /** ---------------- PRODUCT SELECT ---------------- */
        when(con.prepareStatement(startsWith("select * from products"))).thenReturn(prodStmt);
        when(prodStmt.executeQuery()).thenReturn(prodRs);

        when(prodRs.next()).thenReturn(true, false);
        when(prodRs.getInt(1)).thenReturn(2);         // product id
        when(prodRs.getString(2)).thenReturn("Mobile");
        when(prodRs.getString(3)).thenReturn("Electronics");
        when(prodRs.getInt(4)).thenReturn(15000);     // price

        /** ---------------- ORDER INSERT ---------------- */
        when(con.prepareStatement(startsWith("insert into orders"), anyInt())).thenReturn(orderStmt);
        when(orderStmt.executeUpdate()).thenReturn(1);

        when(orderStmt.getGeneratedKeys()).thenReturn(keyRs);
        when(keyRs.next()).thenReturn(true, false);   // MUST (prevents infinite loop)
        when(keyRs.getInt(1)).thenReturn(999);        // generated orderId

        /** ---------------- ORDER ITEMS INSERT ---------------- */
        when(con.prepareStatement(startsWith("insert into order_items"))).thenReturn(itemStmt);
        when(itemStmt.executeUpdate()).thenReturn(1);

        /** ---------------- UPDATE PRODUCT QTY ---------------- */
        when(con.prepareStatement(startsWith("update products"))).thenReturn(updateStmt);
        when(updateStmt.executeUpdate()).thenReturn(1);

        /** ---------------- DELETE CART ---------------- */
        when(con.prepareStatement(startsWith("delete from cart"))).thenReturn(deleteStmt);
        when(deleteStmt.executeUpdate()).thenReturn(1);

        /** ---------------- EXECUTE METHOD ---------------- */
        int result = user.orderItem(con, 10);

        /** ---------------- VERIFY ---------------- */
        assertEquals(1, result);
    }


    // ----------------------------------------------------------------------
    // 7. removeItemFromCart()
    // ----------------------------------------------------------------------
    @Test
    public void testRemoveItemSuccess() throws Exception {
        user.setScanner(new Scanner("5\n"));

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeUpdate()).thenReturn(1);

        int result = user.removeItemFromCart(con, 10);

        assertEquals(1, result);
    }

    // ----------------------------------------------------------------------
    // 8. fetchMyOrders()
    // ----------------------------------------------------------------------
    @Test
    public void testFetchMyOrders() throws Exception {

        PreparedStatement orderStmt = mock(PreparedStatement.class);
        PreparedStatement itemStmt = mock(PreparedStatement.class);
        PreparedStatement prodStmt = mock(PreparedStatement.class);

        ResultSet orderRs = mock(ResultSet.class);
        ResultSet itemRs = mock(ResultSet.class);
        ResultSet prodRs = mock(ResultSet.class);

        when(con.prepareStatement(contains("from orders"))).thenReturn(orderStmt);
        when(con.prepareStatement(contains("from order_items"))).thenReturn(itemStmt);
        when(con.prepareStatement(contains("from products"))).thenReturn(prodStmt);

        when(orderStmt.executeQuery()).thenReturn(orderRs);
        when(itemStmt.executeQuery()).thenReturn(itemRs);
        when(prodStmt.executeQuery()).thenReturn(prodRs);

        when(orderRs.next()).thenReturn(true, false);
        when(orderRs.getInt(1)).thenReturn(100);

        when(itemRs.next()).thenReturn(true, false);
        when(itemRs.getInt(3)).thenReturn(2);
        when(itemRs.getInt(4)).thenReturn(3);

        when(prodRs.next()).thenReturn(true);
        when(prodRs.getString(2)).thenReturn("Mobile");
        when(prodRs.getInt(4)).thenReturn(15000);

        int result = user.fetchMyOrders(con, 10);

        assertEquals(1, result);
    }
}
