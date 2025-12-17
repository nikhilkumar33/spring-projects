package com.sbi.banking.exception;

public class InsufficientBalanceException extends RuntimeException
{
	public InsufficientBalanceException(String message)
	{
		super(message);
	}
}
