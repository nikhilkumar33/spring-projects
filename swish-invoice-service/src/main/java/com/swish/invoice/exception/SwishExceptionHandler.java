package com.swish.invoice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.swish.invoice.repository.InvoiceRepository;
import com.swish.invoice.response.ErrorResponse;

@RestControllerAdvice
public class SwishExceptionHandler
{

    private final InvoiceRepository invoiceRepository;

    SwishExceptionHandler(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<ErrorResponse> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setErrorCode("IIND-105");
		errorResponse.setErrorMessage(ex.getMessage());
		
		return ResponseEntity.ok(errorResponse);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoDataFoundException(NoDataFoundException ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("NDF-505");
		errorResponse.setErrorMessage(ex.getMessage());
		
		return ResponseEntity.ok(errorResponse);
	}
}
