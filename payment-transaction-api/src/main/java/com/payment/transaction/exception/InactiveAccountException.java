package com.payment.transaction.exception;

public class InactiveAccountException extends RuntimeException
{
	public InactiveAccountException(String message)
	{
		super(message);
	}
}
