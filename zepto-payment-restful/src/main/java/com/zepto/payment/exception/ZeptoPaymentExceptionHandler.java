package com.zepto.payment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.payment.response.ErrorMessage;

@RestControllerAdvice
public class ZeptoPaymentExceptionHandler
{
	@ExceptionHandler(PaymentFailedException.class)
	public ResponseEntity<ErrorMessage> handleException(PaymentFailedException ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setError(ex.getMessage());
		errorMessage.setMessageCode("PAY-005");
		return ResponseEntity.ok(errorMessage);
	}

}
