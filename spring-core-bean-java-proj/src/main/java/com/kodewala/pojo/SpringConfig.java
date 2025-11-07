package com.kodewala.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean("order")
	public Order createOrderBean()
	{
		Order order = new Order();
		order.setOrderId(11);
		order.setItemName("macbook");
		order.setStatus("delivered");
		return order;
	}
}
