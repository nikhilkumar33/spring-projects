package com.sbi.banking.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sbi.banking.response.ErrorResponse;

@RestControllerAdvice
public class SBIExceptionHandler 
{
	@ExceptionHandler(InactiveAccountException.class)
	public ResponseEntity<ErrorResponse> handleInactiveAccountException(InactiveAccountException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("IAC-101");
		errorResponse.setErrorMessage(ex.getMessage());
		return ResponseEntity.ok(errorResponse);
	}
	
	@ExceptionHandler(InvalidAccountNumberException.class)
	public ResponseEntity<ErrorResponse> handleInvalidAccountNumberException(InvalidAccountNumberException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("WAC-505");
		errorResponse.setErrorMessage(ex.getMessage());
		return ResponseEntity.ok(errorResponse);
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(InsufficientBalanceException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("INB-103");
		errorResponse.setErrorMessage(ex.getMessage());
		return ResponseEntity.ok(errorResponse);
	}
}
