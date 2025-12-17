package com.sbi.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.banking.request.TransferRequest;
import com.sbi.banking.service.FundTransferService;

@RestController
public class FundTransferController {

	@Autowired
	FundTransferService fundTransferService;
	
	
	@PostMapping("transferFund")
	public ResponseEntity transferFund(@RequestBody TransferRequest transferRequest)
	{
		String response = fundTransferService.transferFundService(transferRequest);
		return ResponseEntity.ok(response);
	}
}
