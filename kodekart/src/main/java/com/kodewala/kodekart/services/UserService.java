package com.kodewala.kodekart.services;

import java.sql.Connection;

public interface UserService {

	int userHome();

	int viewProducts(Connection con);

	int searchProduct(Connection con);

	int addToCart(Connection con, int userId);

	int viewCart(Connection con, int userId);

	int orderItem(Connection con, int userId);

	int removeItemFromCart(Connection con, int userId);

	int fetchMyOrders(Connection con, int userId);

}
