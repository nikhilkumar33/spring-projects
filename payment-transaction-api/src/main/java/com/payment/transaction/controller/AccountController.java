package com.payment.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.transaction.request.AccountRequest;
import com.payment.transaction.service.AccountService;

@RestController
public class AccountController
{
	@Autowired
	AccountService accountService;
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestBody AccountRequest accountRequest)
	{
		int id = accountService.createAccount(accountRequest);
		return "Account created successfully.. Account id is: "+id;
	}
}
