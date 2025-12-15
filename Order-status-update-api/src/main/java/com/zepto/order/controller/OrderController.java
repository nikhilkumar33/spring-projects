package com.zepto.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.order.request.OrderStatusRequest;
import com.zepto.order.request.Orders;
import com.zepto.order.response.OrderResponse;
import com.zepto.order.service.OrderService;

@RestController
public class OrderController 
{
	@Autowired
	OrderService orderService;
	
	@PostMapping("/createOrder")
	public ResponseEntity createOrder(@RequestBody Orders Order)
	{
		System.out.println("hello");
		int id = orderService.createOrder(Order);
		return ResponseEntity.ok("Your order placed.. We will deliver soon.. Your Order id is: "+id );
	}
	
	
	@PutMapping("/orders/{id}/status")
	public ResponseEntity<OrderResponse> updateOrderStatus(@PathVariable int id,@RequestBody OrderStatusRequest statusRequest)
	{
		System.out.println(statusRequest.getNewStatus());
		
		OrderResponse response = orderService.updateOrderStatus(id,statusRequest.getNewStatus());
		return ResponseEntity.ok(response);
	}

}
