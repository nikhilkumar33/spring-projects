package com.kodewala.kodekart.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kodewala.kodekart.pojo.Products;

public class AdminImplementation implements AdminService {
	Scanner sc = new Scanner(System.in);

	@Override
	public int adminHome() {
		while (true) {
			System.out.println("1. Add Product");
			System.out.println("2. Update Product");
			System.out.println("3. Delete Product");
			System.out.println("4. View All Products");
			System.out.println("5. View All Orders");
			System.out.println("6. Logout");
			int choice = sc.nextInt();
			sc.nextLine();
			if (choice > 0 && choice < 7) {
				return choice;
			} else {
				System.out.println("Invalid choice! Chose number between (1-5)");
			}
		}
	}

	@Override
	public int addProduct(Connection con) {
		try {
			String addingProd = "yes";
			String query = "insert into products(name,category,price,quantity,description) values (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			while (addingProd.equals("yes")) {
				System.out.println("Enter Product name: ");
				String name = sc.nextLine();
				System.out.println("Enter Product category: ");
				String category = sc.nextLine();
				System.out.println("Enter Product price: ");
				int price = sc.nextInt();
				System.out.println("Enter Product quantity: ");
				int qty = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Product description: ");
				String desc = sc.nextLine();

				Products prod = new Products(name, category, price, qty, desc);
				pstmt.setString(1, prod.getName());
				pstmt.setString(2, prod.getCategory());
				pstmt.setInt(3, prod.getPrice());
				pstmt.setInt(4, prod.getQuantity());
				pstmt.setString(5, prod.getDescription());
				pstmt.addBatch();

				System.out.println("Do you want to add more product? (yes/no): ");
				addingProd = sc.nextLine();
			}

			int[] result = pstmt.executeBatch();
			if (result.length > 0)
				System.out.println("Successfully added " + result.length + " products");
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateProducts(Connection con) {
		String readQuery = "select * from products";
		try {
			PreparedStatement pstmt = con.prepareStatement(readQuery);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("=============================================================================");
			System.out.println("=============================== ALL PRODUCTS ================================");
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1) + " | P.Name: " + rs.getString(2) + " | P.Category: "
						+ rs.getString(3) + " | P.Price: Rs. " + rs.getInt(4) + " | P.Quantity: " + rs.getInt(5)
						+ " | P.Desc: " + rs.getString(6));
			}
			System.out.println("=============================================================================");
			String flag = "yes";
			while (flag.equals("yes")) {
				System.out.println("1. Update product name");
				System.out.println("2. Update product category");
				System.out.println("3. Update product price");
				System.out.println("4. Update product quantity");
				System.out.println("5. Update product description");
				int choice = sc.nextInt();
				sc.nextLine();
				if (choice > 0 && choice < 6) {
					if (choice == 1) {
						String updateName = "update products set name= ? where id= ?";
						pstmt = con.prepareStatement(updateName);
						System.out.println("Enter the product name to update: ");
						pstmt.setString(1, sc.nextLine());
						System.out.println("Enter the product id to update the name: ");
						pstmt.setInt(2, sc.nextInt());
						pstmt.executeUpdate();
						System.out.println("Row updated");
					} else if (choice == 2) {
						String updateCat = "update products set category= ? where id= ?";
						pstmt = con.prepareStatement(updateCat);
						System.out.println("Enter the product category to update: ");
						pstmt.setString(1, sc.nextLine());
						System.out.println("Enter the product id to update the category: ");
						pstmt.setInt(2, sc.nextInt());
						pstmt.executeUpdate();
						System.out.println("Row updated");
					} else if (choice == 3) {
						String updatePrice = "update products set price= ? where id= ?";
						pstmt = con.prepareStatement(updatePrice);
						System.out.println("Enter the product price to update: ");
						pstmt.setInt(1, sc.nextInt());
						System.out.println("Enter the product id to update the price: ");
						pstmt.setInt(2, sc.nextInt());
						pstmt.executeUpdate();
						System.out.println("Row updated");
					} else if (choice == 4) {
						String updateQty = "update products set quantity= ? where id= ?";
						pstmt = con.prepareStatement(updateQty);
						System.out.println("Enter the product quantity to update: ");
						pstmt.setInt(1, sc.nextInt());
						System.out.println("Enter the product id to update the quantity: ");
						pstmt.setInt(2, sc.nextInt());
						sc.nextLine();
						pstmt.executeUpdate();
						System.out.println("Row updated");
					} else {
						String updateDesc = "update products set description= ? where id= ?";
						pstmt = con.prepareStatement(updateDesc);
						System.out.println("Enter the product description to update: ");
						pstmt.setString(1, sc.nextLine());
						System.out.println("Enter the product id to update the description: ");
						pstmt.setInt(2, sc.nextInt());
						pstmt.executeUpdate();
						System.out.println("Row updated");
					}
					sc.nextLine();
					System.out.println("Do you want to update more product? (yes/no): ");
					flag = sc.nextLine();
				} else {
					System.out.println("Invalid choice! Choose number between (1-5)");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int deleteProduct(Connection con) {
		String readQuery = "select * from products";
		try {
			PreparedStatement pstmt = con.prepareStatement(readQuery);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("=============================================================================");
			System.out.println("=============================== ALL PRODUCTS ================================");
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1) + " | P.Name: " + rs.getString(2) + " | P.Category: "
						+ rs.getString(3) + " | P.Price: Rs. " + rs.getInt(4) + " | P.Quantity: " + rs.getInt(5)
						+ " | P.Desc: " + rs.getString(6));
			}
			System.out.println("=============================================================================");
			while (true) {
				String query = "delete from products where id= ?";
				pstmt = con.prepareStatement(query);
				System.out.println("Enter the product id to delete: ");
				pstmt.setInt(1, sc.nextInt());
				int rows = pstmt.executeUpdate();
				if (rows > 0) {
					System.out.println("successfully deleted" + rows);
					return 1;
				} else {
					System.out.println("Enter valid product id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int fetchProducts(Connection con) {
		String query = "select * from products";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("=============================================================================");
			System.out.println("=============================== ALL PRODUCTS ================================");
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1) + " | P.Name: " + rs.getString(2) + " | P.Category: "
						+ rs.getString(3) + " | P.Price: Rs. " + rs.getInt(4) + " | P.Quantity: " + rs.getInt(5)
						+ " | P.Desc: " + rs.getString(6));
			}
			System.out.println("=============================================================================");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int fetchAllOrders(Connection con) {
		String orderQuery = "select * from orders";
		String orderItemQuery = "select * from order_items where order_id=?";
		String productQuery = "select * from products where id=?";

		try {
			PreparedStatement orderStmt = con.prepareStatement(orderQuery);
			ResultSet orderRes = orderStmt.executeQuery();
			System.out.println("=============================================================================");
			System.out.println("========================== ALL ORDERS HISTORY ===============================");
			while (orderRes.next()) {
				int orderId = orderRes.getInt(1);
				int userId = orderRes.getInt(2);
				Date date = orderRes.getDate(3);
				int orderTotal = orderRes.getInt(4);

				PreparedStatement itemStmt = con.prepareStatement(orderItemQuery);
				itemStmt.setInt(1, orderId);
				ResultSet itemRes = itemStmt.executeQuery();

				while (itemRes.next()) {
					int prodId = itemRes.getInt(3);
					int qty = itemRes.getInt(4);

					PreparedStatement prodStmt = con.prepareStatement(productQuery);
					prodStmt.setInt(1, prodId);
					ResultSet prodRes = prodStmt.executeQuery();
					
					if (prodRes.next()) {
						String prodName = prodRes.getString(2);
						int price = prodRes.getInt(4);

						System.out.println("OrderId: " + orderId + " | UserId: " + userId + " | ProductId: " + prodId
								+ " | Name: " + prodName + " | Order Date: " + date + " | Qty: " + qty + " | Price: Rs. "
								+ price + " | Total: Rs. " + orderTotal);
					}
				}
			} 
			System.out.println("=============================================================================");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
