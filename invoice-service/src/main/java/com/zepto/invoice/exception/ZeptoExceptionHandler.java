package com.zepto.invoice.exception;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.invoice.response.ErrorResponse;

@RestControllerAdvice
public class ZeptoExceptionHandler 
{
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorResponse> handleInvalidIdException()
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("IID-101");
		errorResponse.setErrorMessage("Invalid invoice id..");
		return ResponseEntity.ok(errorResponse);
	}

}
