package com.kodewala.kodekart.controller;

import java.sql.Connection;

import com.kodewala.kodekart.services.AdminImplementation;
import com.kodewala.kodekart.services.AdminService;
import com.kodewala.kodekart.services.KodeKartImplementation;
import com.kodewala.kodekart.services.KodeKartService;
import com.kodewala.kodekart.services.UserImplementation;
import com.kodewala.kodekart.services.UserService;

public class UserController {

	public int controlUser(Connection con) {
		KodeKartService service;
		// upcasting
		service = new KodeKartImplementation();

		AdminService adService = new AdminImplementation();
		UserService usService = new UserImplementation();
		while (true) {
			while (true) {
				int choice = service.basePage();

				switch (choice) {
				case 1: {
					while (true) {
						boolean result = service.register(con);
						if (result == true) {
							System.out.println("Register success..!");
							break;
						} else {
							System.out.println("Register fail email already exists");
							System.out.println("Try Again to Register.....");
						}
					}
				}
					break;
				case 2: {

					boolean result = service.isAdmin(con);

					// it loops until we didn't provide valid credential
					int userId = 0;
					while (true) {
						userId = service.login(con);
						if (userId > 0) {
							break;
						} else {
							System.out.println("Invalid Credential..!");
							System.out.println("Try Again..........!");
						}
					}

					if (result == true) {
						System.out.println("===== ADMIN HOME =====");
						adminLoop: while (true) {
							int adChoice = adService.adminHome();
							switch (adChoice) {
							case 1:
								adService.addProduct(con);
								break;
							case 2:
								adService.updateProducts(con);
								break;
							case 3:
								adService.deleteProduct(con);
								break;
							case 4:
								adService.fetchProducts(con);
								break;
							case 5:
								adService.fetchAllOrders(con);
								break;
							case 6:
								break adminLoop;
							}
						}
					} else {
						System.out.println("===== USER HOME =====");

						userLoop: while (true) {
							int userChoice = usService.userHome();
							switch (userChoice) {
							case 1:
								usService.viewProducts(con);
								break;
							case 2:
								usService.searchProduct(con);
								break;
							case 3:
								usService.addToCart(con, userId);
								break;
							case 4:
								int res = usService.viewCart(con, userId);
								if (res == 1) {
									usService.orderItem(con, userId);
								} else if (res == 2) {
									usService.removeItemFromCart(con, userId);
								}
								break;
							case 5:
								usService.fetchMyOrders(con, userId);
								break;
							case 6:
								break userLoop;
							}
						}
					}
					break;
				}
				case 3: {
					System.out.println("KodeKart Closed");
					return 0;
				}
				}
			}
		}
	}

}
