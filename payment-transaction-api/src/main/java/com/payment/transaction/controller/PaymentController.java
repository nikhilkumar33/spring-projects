package com.payment.transaction.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.transaction.exception.InvalidPaymentTypeException;
import com.payment.transaction.request.PaymentRequest;
import com.payment.transaction.response.ErrorResponse;
import com.payment.transaction.service.PaymentService;

@RestController
public class PaymentController 
{
	@Autowired
	Map<String, PaymentService> paymentService;
	
	@PutMapping("/makePayment")
	public String makePayment(@RequestBody PaymentRequest paymentRequest)
	{
		String type = paymentRequest.getPaymentType();
		if(! paymentService.containsKey(type)) {
			throw new InvalidPaymentTypeException("Invalid payment type... "+type);
		}
		PaymentService service = paymentService.get(type);
		String response = service.processPayment(paymentRequest);
		return response;
	}
	
	@ExceptionHandler(InvalidPaymentTypeException.class)
	public ResponseEntity<ErrorResponse> handleInvalidPaymentTypeException(InvalidPaymentTypeException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("IPTYPE-103");
		errorResponse.setErrorMessage(ex.getMessage());
		return ResponseEntity.ok(errorResponse);
	}
}
