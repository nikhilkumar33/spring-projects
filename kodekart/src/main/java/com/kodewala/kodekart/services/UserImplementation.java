package com.kodewala.kodekart.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kodewala.kodekart.pojo.Cart;
import com.kodewala.kodekart.pojo.OrderItems;
import com.kodewala.kodekart.pojo.Orders;

public class UserImplementation implements UserService {
	Scanner sc = new Scanner(System.in);
	public void setScanner(Scanner scanner) {
	    this.sc = scanner;
	}

	@Override
	public int userHome() {
		while (true) {
			System.out.println("1. View All Products");
			System.out.println("2. Search Product");
			System.out.println("3. Item Add to Cart");
			System.out.println("4. View Cart");
			System.out.println("5. My Orders");
			System.out.println("6. Logout");
			int choice = sc.nextInt();
			sc.nextLine();
			if (choice > 0 && choice < 7) {
				return choice;
			} else {
				System.out.println("Invalid choice! Chose number between (1-6)");
			}
		}
	}

	@Override
	public int viewProducts(Connection con) {
		String readQuery = "select * from products";
		try {
			PreparedStatement pstmt = con.prepareStatement(readQuery);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("=============================================================================");
			System.out.println("============================= ALL PRODUCTS ==================================");
			while (rs.next()) {
				// checking is product available to buy or not
				if (rs.getInt(5) > 0) {
					System.out.println("P.Id: " + rs.getInt(1) + " | P.Name: " + rs.getString(2) + " | P.Category: "
							+ rs.getString(3) + " | P.Price: Rs. " + rs.getInt(4) + " | P.Desc: " + rs.getString(6));
				}
			}
			System.out.println("=============================================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int searchProduct(Connection con) {
		System.out.println("Enter product name/category: ");
		String input = sc.nextLine().toLowerCase();
		String readQuery = "select * from products";
		try {
			PreparedStatement pstmt = con.prepareStatement(readQuery);
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			System.out.println("=============================================================================");
			System.out.println("============================= PRODUCTS ======================================");
			while (rs.next()) {
				String prodName = rs.getString(2).toLowerCase();
				String prodCategory = rs.getString(3).toLowerCase();
				if (prodName.contains(input) || prodCategory.contains(input)) {
					System.out.println("P.Id: " + rs.getInt(1) + " | P.Name: " + rs.getString(2) + " | P.Category: "
							+ rs.getString(3) + " | P.Price: Rs. " + rs.getInt(4) + " | P.Desc: " + rs.getString(6));
					count++;
				}
			}
			System.out.println("=============================================================================");
			if (count == 0) {
				System.out.println("No product found!");
				return 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int addToCart(Connection con, int userId) {
		System.out.println("Enter product id to add in cart: ");
		int prodId = sc.nextInt();
		System.out.println("Enter the quantity to add in cart: ");
		int prodQty = sc.nextInt();
		sc.nextLine();
		String prodQuery = "select id from products where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(prodQuery);
			pstmt.setInt(1, prodId);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("Incorrect product id! ");
				return 0;
			}

			else {
				Cart cart = new Cart(userId, prodId, prodQty);

				String query = "insert into cart (user_id,product_id,quantity) values (?,?,?)";

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, cart.getUserId());
				pstmt.setInt(2, cart.getProductId());
				pstmt.setInt(3, cart.getQuantity());

				pstmt.executeUpdate();
				System.out.println("Successfully item added to cart!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int viewCart(Connection con, int userId) {
		String cartQuery = "select * from cart where user_id=?";
		String prodQuery = "select * from products where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(cartQuery);
			pstmt.setInt(1, userId);
			ResultSet cartResult = pstmt.executeQuery();
			int totalPrice = 0;
			int price = 0;
			int totalQty = 0;
			System.out.println("=============================================================================");
			System.out.println("============================= MY CART ITEMS =================================");

			// without moving the corsor to next it check any element present or not
			if (!cartResult.isBeforeFirst()) {
				System.out.println("No record found! ");
			} else {
				while (cartResult.next()) {
					int prodId = cartResult.getInt(3);
					pstmt = con.prepareStatement(prodQuery);
					pstmt.setInt(1, prodId);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						System.out.println("CartId: " + cartResult.getInt(1) + " | P.Name: " + rs.getString(2)
								+ " | P.Category: " + rs.getString(3) + " | Quantity: " + cartResult.getInt(4)
								+ " | P.Price: Rs. " + rs.getInt(4));
						price = rs.getInt(4);
						totalQty = cartResult.getInt(4);
						totalPrice += (price * totalQty);
					}
				}
				System.out.println("=============================================================================");
				System.out.println("Total price: Rs. " + totalPrice);
				while (true) {
					System.out.println("1. Place order");
					System.out.println("2. Remove item from cart");
					System.out.println("3. Main Menu.");
					int choice = sc.nextInt();
					sc.nextLine();
					if (choice > 0 && choice < 4) {
						return choice;
					} else {
						System.out.println("Inavalid choice! Choose number between (1-3)");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 3;
	}

	@Override
	public int orderItem(Connection con, int userId) {
		String query = "select * from cart where user_id=?";
		String prodQuery = "select * from products where id=?";
		String orderQuery = "insert into orders(user_id,order_date,total_amount) values(?,?,?)";
		String updateQtyQuery = "update products set quantity = quantity - ? where id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet cartResult = pstmt.executeQuery();
			int totalPrice = 0;
			int price = 0;
			int totalQty = 0;

			List<OrderItems> itemsList = new ArrayList<OrderItems>();
			System.out.println("=============================================================================");
			System.out.println("============================== Order Items ==================================");
			while (cartResult.next()) {
				int prodId = cartResult.getInt(3);
				pstmt = con.prepareStatement(prodQuery);
				pstmt.setInt(1, prodId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println("CartId: " + cartResult.getInt(1) + " | P.Name: " + rs.getString(2)
							+ " | P.Category: " + rs.getString(3) + " | Quantity: " + cartResult.getInt(4));
					price = rs.getInt(4);
					totalQty = cartResult.getInt(4);
					totalPrice += (price * totalQty);
					itemsList.add(new OrderItems(0, rs.getInt(1), cartResult.getInt(4), totalPrice));
				}
			}
			System.out.println("=============================================================================");
			System.out.println("Total price: Rs. " + totalPrice);

			Orders orders = new Orders(userId, LocalDate.now(), totalPrice);

			pstmt = con.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, orders.getUserId());
			pstmt.setDate(2, java.sql.Date.valueOf(orders.getOrderDate()));
			pstmt.setInt(3, orders.getTotalAmount());
			pstmt.executeUpdate();
			System.out.println("Order placed!");

			ResultSet orderKeys = pstmt.getGeneratedKeys();
			int orderId = 0;
			while (orderKeys.next()) {
				orderId = orderKeys.getInt(1);
			}
			// updating the order items
			String orderItemQuery = "insert into order_items (order_id,product_id,quantity,price) values(?,?,?,?)";
			for (OrderItems items : itemsList) {
				OrderItems orderItems = new OrderItems(orderId, items.getProductId(), items.getQuantity(),
						items.getPrice());

				pstmt = con.prepareStatement(orderItemQuery);
				pstmt.setInt(1, orderItems.getOrderId());
				pstmt.setInt(2, orderItems.getProductId());
				pstmt.setInt(3, orderItems.getQuantity());
				pstmt.setInt(4, orderItems.getPrice());

				pstmt.executeUpdate();

				// updating the product qty
				pstmt = con.prepareStatement(updateQtyQuery);
				pstmt.setInt(1, items.getQuantity());
				pstmt.setInt(2, items.getProductId());
				pstmt.executeUpdate();
			}
			// deleted items from cart once order placed
			String deleteQuery = "delete from cart where user_id=?";
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int removeItemFromCart(Connection con, int userId) {
		String query = "delete from cart where id=?";
		System.out.println("Enter cart id to remove product from cart: ");
		int cartId = sc.nextInt();
		while (true) {
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, cartId);
				int count = pstmt.executeUpdate();
				if (count > 0) {
					System.out.println("Item removed from cart.");
					return 1;
				} else {
					System.out.println("Invalid cart id! Try again!");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int fetchMyOrders(Connection con, int userId) {
		String orderQuery = "select * from orders where user_id=?";
		String orderItemQuery = "select * from order_items where order_id=?";
		String productQuery = "select * from products where id=?";
		try {
			PreparedStatement orderStmt = con.prepareStatement(orderQuery);
			orderStmt.setInt(1, userId);
			ResultSet orderRes = orderStmt.executeQuery();
			System.out.println("=============================================================================");
			System.out.println("============================== MY ORDERS ====================================");
			while (orderRes.next()) {
				int orderId = orderRes.getInt(1);

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

						System.out.println("Order Id: " + orderId + " | Product ID: " + prodId + " | Name: " + prodName
								+ " | Qty: " + qty + " | Price: Rs. " + price + " | Total: Rs. " + (qty * price));
					}
				}
			}
			System.out.println("=============================================================================");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

}
