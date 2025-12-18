package com.payment.transaction.exception;

public class InvalidPaymentTypeException extends RuntimeException
{
	public InvalidPaymentTypeException(String message)
	{
		super(message);
	}
}
