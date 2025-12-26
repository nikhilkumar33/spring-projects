package com.zepto.payment.service;

import org.springframework.stereotype.Service;

@Service
public class AirtelPayment implements PaymentService
{

	@Override
	public int pay() {
		System.out.println("AirtelPayment...");
		return 0;
	}

}