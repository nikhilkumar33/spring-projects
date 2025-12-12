package com.instamart.invoice.exception;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.instamart.invoice.response.ErrorMsessage;

@RestControllerAdvice
public class InstamartExceptionHandler 
{
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorMsessage> handleInvalidIdException()
	{
		ErrorMsessage errorMsessage = new ErrorMsessage();
		errorMsessage.setErrorCode("IID-101");
		errorMsessage.setErrorMessage("You entered Invalid invoice id");
		return ResponseEntity.ok(errorMsessage);
	}
	
	
	@ExceptionHandler(DeactivatedInvoiceException.class)
	public ResponseEntity<ErrorMsessage> handleDeactivatedInvoiceException(DeactivatedInvoiceException ex)
	{
		ErrorMsessage errorMsessage = new ErrorMsessage();
		errorMsessage.setErrorCode("DID-205");
		errorMsessage.setErrorMessage(ex.getMessage());
		return ResponseEntity.ok(errorMsessage);
	}
}
