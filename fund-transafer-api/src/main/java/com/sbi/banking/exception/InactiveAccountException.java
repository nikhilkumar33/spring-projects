package com.sbi.banking.exception;

public class InactiveAccountException extends RuntimeException
{
	public InactiveAccountException(String message)
	{
		super(message);
	}
}
