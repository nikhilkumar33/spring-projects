package com.zepto.payment.service;

import org.springframework.stereotype.Service;

@Service
public class WalletPayment  implements PaymentService
{

	@Override
	public int pay() {
		System.out.println("WalletPayment...");
		return 0;
	}

}
