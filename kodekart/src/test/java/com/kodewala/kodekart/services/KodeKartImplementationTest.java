package com.kodewala.kodekart.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class KodeKartImplementationTest {

    private KodeKartImplementation service;
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Scanner scanner;

    @Before
    public void setUp() {
        service = new KodeKartImplementation();

        // mock DB
        con = mock(Connection.class);
        pstmt = mock(PreparedStatement.class);
        rs = mock(ResultSet.class);

        // mock Scanner
        scanner = mock(Scanner.class);
        service.setScanner(scanner);
    }

    // --------------------------------------------------------------------
    // 1️⃣ basePage()
    // --------------------------------------------------------------------
    @Test
    public void testBasePage_ValidChoice() {
        when(scanner.nextInt()).thenReturn(2); // Login
        when(scanner.nextLine()).thenReturn("");

        int result = service.basePage();
        assertEquals(2, result);
    }

    // --------------------------------------------------------------------
    // 2️⃣ register()
    // --------------------------------------------------------------------
    @Test
    public void testRegister_NewUser_Success() throws Exception {

        // Simulate user input
        when(scanner.nextLine())
                .thenReturn("Nikhil")        // name
                .thenReturn("test@gmail.com") // email
                .thenReturn("9999999999")     // phone
                .thenReturn("pass123");       // password

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        // User does not exist
        when(rs.next()).thenReturn(false);

        // Simulate insert success
        when(pstmt.executeUpdate()).thenReturn(1);

        boolean result = service.register(con);
        assertTrue(result);
    }

    @Test
    public void testRegister_UserAlreadyExists() throws Exception {

        when(scanner.nextLine())
                .thenReturn("Nikhil")
                .thenReturn("test@gmail.com")
                .thenReturn("9999999999")
                .thenReturn("pass123");

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        // rs.next() = true → email already exists
        when(rs.next()).thenReturn(true);

        boolean result = service.register(con);
        assertFalse(result);
    }

    // --------------------------------------------------------------------
    // 3️⃣ isAdmin()
    // --------------------------------------------------------------------
    @Test
    public void testIsAdmin_AdminLogin() {
        when(scanner.nextInt()).thenReturn(1); // admin
        when(scanner.nextLine()).thenReturn("");

        boolean result = service.isAdmin(con);
        assertTrue(result);
    }

    @Test
    public void testIsAdmin_UserLogin() {
        when(scanner.nextInt()).thenReturn(2); // normal user
        when(scanner.nextLine()).thenReturn("");

        boolean result = service.isAdmin(con);
        assertFalse(result);
    }

    // --------------------------------------------------------------------
    // 4️⃣ login()
    // --------------------------------------------------------------------
    @Test
    public void testLogin_Success() throws Exception {

        when(scanner.nextLine())
                .thenReturn("test@gmail.com") // email
                .thenReturn("pass123");       // password

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        // Simulate DB row
        when(rs.next()).thenReturn(true);
        when(rs.getString(5)).thenReturn("pass123");
        when(rs.getInt(1)).thenReturn(10); // user ID

        int result = service.login(con);
        assertEquals(10, result);
    }

    @Test
    public void testLogin_InvalidPassword() throws Exception {

        when(scanner.nextLine())
                .thenReturn("test@gmail.com")
                .thenReturn("wrongPass");

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        when(rs.next()).thenReturn(true);
        when(rs.getString(5)).thenReturn("correctPass");

        int result = service.login(con);
        assertEquals(0, result);
    }

    @Test
    public void testLogin_UserNotFound() throws Exception {

        when(scanner.nextLine())
                .thenReturn("test@gmail.com")
                .thenReturn("pass123");

        when(con.prepareStatement(anyString())).thenReturn(pstmt);
        when(pstmt.executeQuery()).thenReturn(rs);

        when(rs.next()).thenReturn(false);

        int result = service.login(con);
        assertEquals(0, result);
    }
}
