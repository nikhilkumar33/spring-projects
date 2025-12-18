package com.payment.transaction.exception;

public class InsufficientBalanceException extends RuntimeException
{
	public InsufficientBalanceException(String message)
	{
		super(message);
	}
}
