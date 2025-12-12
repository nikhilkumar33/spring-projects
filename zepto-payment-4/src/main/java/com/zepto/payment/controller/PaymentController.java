package com.zepto.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zepto.payment.request.PaymentInfo;

@RestController
public class PaymentController 
{

	@PostMapping("processPayment")
	public ResponseEntity processPayment(@RequestBody PaymentInfo paymentInfo)
	{
		System.out.println(paymentInfo.getPaymentId());
		return ResponseEntity.ok("Received payment details...");
	}

}
