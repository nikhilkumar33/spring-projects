package com.flipkart.payment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flipkart.payment.response.ErrorMessage;

@RestControllerAdvice
public class FlipkartExceptionHandler 
{
	@ExceptionHandler(PaymentFailedException.class)
	public ResponseEntity<ErrorMessage> handelPaymentFailException(PaymentFailedException ex)
	{
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode("PAY-004");
		errorMessage.setErrorMsg(ex.getMessage());
		
		return ResponseEntity.ok(errorMessage);
	}
}
