package com.zepto.payment.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UPIPayment implements PaymentService
{

	@Override
	public int pay() {
		System.out.println("UPIPayment...");
		return 0;
	}

}
