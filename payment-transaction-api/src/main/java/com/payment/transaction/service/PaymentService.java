package com.payment.transaction.service;

import org.springframework.stereotype.Service;

import com.payment.transaction.request.PaymentRequest;

@Service
public interface PaymentService
{
	public String processPayment(PaymentRequest paymentRequest);
}
