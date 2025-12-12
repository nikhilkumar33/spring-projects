package com.instamart.invoice.exception;

public class DeactivatedInvoiceException extends RuntimeException
{
	public DeactivatedInvoiceException(String message)
	{
		super(message);
	}
}
