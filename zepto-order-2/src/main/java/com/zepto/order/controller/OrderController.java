package com.zepto.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.order.request.OrderInfo;

@RestController
public class OrderController 
{
	@PostMapping("processOrder")
	public ResponseEntity<String> createOrder(@RequestBody OrderInfo orderInfo)
	{
		System.out.println("Item name: "+orderInfo.getItemName());
		return ResponseEntity.ok("We got the order details.. soon we will place...");
	}

}
