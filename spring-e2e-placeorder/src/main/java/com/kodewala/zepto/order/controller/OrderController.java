package com.kodewala.zepto.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodewala.zepto.order.bean.OrderInfo;
import com.kodewala.zepto.order.service.OrderService;


@Controller
public class OrderController 
{
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/showOrderPage")
	public String viewOrderPage()
	{
		System.out.println("viewOrderPage()........");
		return "order";
	}
	
	@PostMapping("/placeOrder")
	public String placeOrder(@ModelAttribute OrderInfo orderInfo, Model model)
	{
		System.out.println("placeOrder(): Controller: Item name: "+orderInfo.getItem());
		int orderId = orderService.createOrderService(orderInfo);
		System.out.println("Order ID : "+orderId);
		
		model.addAttribute("orderId", orderId);
		return "order-success";
	}
}
