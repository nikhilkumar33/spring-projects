package com.kodewala.kodekart.pojo;

import java.time.LocalDate;

public class Orders 
{
	private int userId;
	private LocalDate orderDate;
	private int totalAmount;
	
	public Orders() {
		super();
	}

	public Orders(int userId, LocalDate orderDate, int totalAmount) {
		super();
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
