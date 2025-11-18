package com.kodewala.kodekart.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kodewala.kodekart.pojo.Users;

public class KodeKartImplementation implements KodeKartService {
	Scanner sc = new Scanner(System.in);
	public void setScanner(Scanner sc) {
	    this.sc = sc;
	}

	@Override
	public int basePage() {
		System.out.println("****************************************");
		System.out.println("          WELCOME TO KODEKART           ");
		System.out.println("****************************************");
		while (true) {
			try {
				System.out.println("-- Home --");
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Close KodeKart");
				int choice = sc.nextInt();
				sc.nextLine();
				if (choice > 0 && choice < 4) {
					return choice;
				} else {
					System.out.println("Invalid choice! Chose number between (1-3)");
				}
			} catch (InputMismatchException e) {
				System.out.println("Input mismatch enter a number between (1-3)");
			}
		}
	}

	@Override
	public boolean register(Connection con) {
		System.out.println("   REGISTER   ");
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter your email: ");
		String email = sc.nextLine();
		System.out.println("Enter your phone: ");
		String phone = sc.nextLine();
		System.out.println("Enter your password: ");
		String password = sc.nextLine();
		Users user = new Users(name, email, phone, password);
		String query = "select * from users where email = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				String insertUser = "insert into users (name,email,phone,password) values(?,?,?,?)";
				pstmt = con.prepareStatement(insertUser);
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPhone());
				pstmt.setString(4, user.getPassword());
				pstmt.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isAdmin(Connection con) {
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as User");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			return true;
		}
		return false;
	}

	@Override
	public int login(Connection con) {
		System.out.println("   LOGIN   ");
		System.out.print("Enter email: ");
		String email = sc.nextLine();
		System.out.print("Enter password: ");
		String password = sc.nextLine();

		String query = "select * from users where email = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPassword = rs.getString(5);
				if (dbPassword.equals(password)) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
