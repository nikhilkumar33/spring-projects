package com.payment.transaction.exception;

public class InvalidAccountNumberException extends RuntimeException
{
	public InvalidAccountNumberException(String message)
	{
		super(message);
	}
}
