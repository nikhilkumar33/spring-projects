package com.flipkart.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flipkart.payment.request.PaymentInfo;
import com.flipkart.payment.response.SuccessMessage;
import com.flipkart.payment.service.IPaymentService;

@Controller
public class PaymentController
{
	@Qualifier("flipkartPayLater")
	@Autowired
	IPaymentService paymentService;
	
	@PostMapping("confirmPayment")
	@ResponseBody
	public ResponseEntity<SuccessMessage> confirmPayment(@RequestBody PaymentInfo paymentInfo)
	{
		System.out.println("Payment Info: "+paymentInfo.getPaymentRef()+" "+paymentInfo.getDescription());
		int paymentId = paymentService.pay(paymentInfo);
		
		SuccessMessage sucMessage = new SuccessMessage();
		sucMessage.setPaymentId(paymentId);
		sucMessage.setPaymentStatus(paymentInfo.getStatus());
		sucMessage.setDescription(paymentInfo.getDescription());
		
		return ResponseEntity.ok(sucMessage);
	}
}
