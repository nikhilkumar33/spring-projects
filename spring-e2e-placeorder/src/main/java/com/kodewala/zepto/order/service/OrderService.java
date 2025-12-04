package com.kodewala.zepto.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.zepto.order.bean.OrderInfo;
import com.kodewala.zepto.order.dao.OrderDAO;
import com.kodewala.zepto.order.entity.Orders;

@Service
public class OrderService 
{
	@Autowired
	OrderDAO orderDAO;
	
	public int createOrderService(OrderInfo orderInfo)
	{
		System.out.println("createOrderService()...."+orderInfo.getItem());
		Orders orders = new Orders();
		orders.setItem(orderInfo.getItem());
		orders.setQty(orderInfo.getQty());
		orders.setPrice(orderInfo.getPrice());
		orders.setAddress(orderInfo.getAddress());
		
		int orderId = orderDAO.createOrder(orders);
		return orderId;
	}
}
