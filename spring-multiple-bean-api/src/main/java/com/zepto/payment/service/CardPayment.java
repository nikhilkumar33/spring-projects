package com.zepto.payment.service;

import org.springframework.stereotype.Service;

@Service
public class CardPayment implements PaymentService
{

	@Override
	public int pay() {
		System.out.println("CardPayment...");
		return 0;
	}

}
