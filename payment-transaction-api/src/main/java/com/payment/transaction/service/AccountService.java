package com.payment.transaction.service;

import org.springframework.stereotype.Service;

import com.payment.transaction.request.AccountRequest;

@Service
public interface AccountService 
{
	public int createAccount(AccountRequest accountRequest);
}
