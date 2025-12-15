package com.zepto.order.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.order.entity.OrderEntity;
import com.zepto.order.exception.InvalidIdException;
import com.zepto.order.exception.PaymentFailedException;
import com.zepto.order.repository.OrderRespository;
import com.zepto.order.request.Orders;
import com.zepto.order.response.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	OrderRespository orderRepository;
	
	@Override
	public int createOrder(Orders order) {
		OrderEntity entity = new OrderEntity();
		if(!order.getPaymentStatus().equals("PAID"))
		{
			throw new PaymentFailedException("Payment failed try again..");
		}
		entity.setItemName(order.getItemName());
		entity.setPaymentStatus(order.getPaymentStatus());
		entity.setAmount(order.getAmount());
		entity.setDescription(order.getDescription());
		
		entity = orderRepository.save(entity);
		
		return entity.getId();
	}

	@Override
	public OrderResponse updateOrderStatus(int id, String newStatus) {
		try {
			OrderEntity entity = orderRepository.findById(id).get();
			entity.setOrderStatus(newStatus);
			entity = orderRepository.save(entity);
		
			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setItemName(entity.getItemName());
			orderResponse.setAmount(entity.getAmount());
			orderResponse.setOrderStatus(entity.getOrderStatus());
			return orderResponse;
		}
		catch(NoSuchElementException ex)
		{
			throw new InvalidIdException("No record found.. Incorrect id.."+id);
		}
	}

}
