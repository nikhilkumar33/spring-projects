package com.amazon.versoning.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amazon.versoning.response.ErrorResponse;

@RestControllerAdvice
public class AmzonExceptionHandler 
{
	@ExceptionHandler(PaymentFailedException.class)
	public ResponseEntity<ErrorResponse> handlePaymentFailedException(PaymentFailedException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("PMT-101");
		errorResponse.setErrorMessage(ex.getMessage());
		
		return ResponseEntity.ok(errorResponse);
	}
}

