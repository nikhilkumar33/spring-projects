package com.zepto.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.payment.request.PaymentRequest;
import com.zepto.payment.service.PaymentService;

@RestController
public class PaymentController 
{
	@Qualifier("cardPayment")
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/confirmPayment")
	public ResponseEntity confirmPayment(@RequestBody PaymentRequest paymentRequest)
	{
		paymentService.pay();
		return ResponseEntity.ok(null);
	}
}
