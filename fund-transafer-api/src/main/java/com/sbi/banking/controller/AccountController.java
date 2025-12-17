package com.sbi.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.banking.request.AccountRequest;
import com.sbi.banking.service.FundTransferService;

@RestController
public class AccountController 
{
	@Autowired
	FundTransferService fundTransferService;
	
	@PostMapping("createAccount")
	public String createSBIAccount(@RequestBody AccountRequest accountRequest)
	{
		System.out.println(accountRequest.getAccountNo());
		int id = fundTransferService.saveAccount(accountRequest);
		return "Account created successfully... Id is: "+id ;
	}
}
