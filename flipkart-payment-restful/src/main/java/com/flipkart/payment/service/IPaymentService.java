package com.flipkart.payment.service;

import org.springframework.stereotype.Service;

import com.flipkart.payment.request.PaymentInfo;

@Service
public interface IPaymentService 
{
	int pay(PaymentInfo paymentInfo);
}
