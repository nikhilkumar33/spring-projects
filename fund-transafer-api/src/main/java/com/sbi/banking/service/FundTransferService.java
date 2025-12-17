package com.sbi.banking.service;

import org.springframework.stereotype.Service;

import com.sbi.banking.request.AccountRequest;
import com.sbi.banking.request.TransferRequest;

@Service
public interface FundTransferService 
{
	public int saveAccount(AccountRequest accountRequest);

	public String transferFundService(TransferRequest transferRequest);
}
