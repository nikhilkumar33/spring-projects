package com.zepto.payment.service;

import org.springframework.stereotype.Service;

import com.zepto.payment.bean.PaymentInfo;

@Service
public interface PaymentService
{
	
	public int pay(PaymentInfo paymentInfo);

}
