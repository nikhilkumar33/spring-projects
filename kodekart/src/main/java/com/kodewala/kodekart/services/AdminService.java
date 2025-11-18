package com.kodewala.kodekart.services;

import java.sql.Connection;

public interface AdminService {

	int adminHome();

	int addProduct(Connection con);

	int updateProducts(Connection con);

	int deleteProduct(Connection con);
	
	int fetchProducts(Connection con);

	int fetchAllOrders(Connection con);

}
