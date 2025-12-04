package com.flipkart.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flipkart.response.ErrorResponse;

@RestControllerAdvice
public class FlipkartExceptionHandler 
{
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateEmailRegisterException(ConstraintViolationException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("REG-101");
		errorResponse.setErrorMessage("Email id already exists... Try with another email..");
		
		return ResponseEntity.ok(errorResponse);
	}

}
