package com.zepto.order.service;

import org.springframework.stereotype.Service;

import com.zepto.order.request.Orders;
import com.zepto.order.response.OrderResponse;

@Service
public interface OrderService {
	
	int createOrder(Orders order);

	OrderResponse updateOrderStatus(int id, String newStatus);
}
