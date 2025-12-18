package com.sbi.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.banking.entity.Account;
import com.sbi.banking.exception.InactiveAccountException;
import com.sbi.banking.exception.InsufficientBalanceException;
import com.sbi.banking.exception.InvalidAccountNumberException;
import com.sbi.banking.repository.FundTransferRepository;
import com.sbi.banking.request.AccountRequest;
import com.sbi.banking.request.TransferRequest;

import jakarta.transaction.Transactional;

@Service
public class FundTransferServiceImpl implements FundTransferService {
	@Autowired
	FundTransferRepository fundTransferRepository;

	@Override
	public int saveAccount(AccountRequest accountRequest) {
		Account account = new Account();

		account.setAccountNo(accountRequest.getAccountNo());
		account.setBalance(accountRequest.getBalance());
		account.setPassword(accountRequest.getPassword());
		account.setMobile(accountRequest.getMobile());
		account.setAadharNo(accountRequest.getAadharNo());

		account = fundTransferRepository.save(account);
		return account.getId();
	}

	@Transactional
	@Override
	public String transferFundService(TransferRequest transferRequest) {

		int amountToBeTransfer = transferRequest.getAmount();

		Account fromAccount = fundTransferRepository.findByAccountNo(transferRequest.getFromAccount());
		if (fromAccount != null)
		{
			if (fromAccount.getStatus().equals("Active")) {
				if (fromAccount.getBalance() > amountToBeTransfer) {
					fromAccount.setBalance(fromAccount.getBalance() - amountToBeTransfer);

					//fromAccount.setPassword("pass@000");
					fundTransferRepository.save(fromAccount);
				} else {
					throw new InsufficientBalanceException(
							"You do not have sufficient balance to transfer. Amount: " + amountToBeTransfer);
				}
			} else {
				throw new InactiveAccountException("Account is deactivated");
			}
		} 
		else {
			throw new InvalidAccountNumberException(
					"No record found for this account no: " + transferRequest.getFromAccount());
		}

		Account toAccount = fundTransferRepository.findByAccountNo(transferRequest.getToAccount());
		if (toAccount != null)
		{
			if (toAccount.getStatus().equals("Active")) {
				toAccount.setBalance(toAccount.getBalance() + amountToBeTransfer);
				fundTransferRepository.save(toAccount);
			} else {
				throw new InactiveAccountException("Account is deactivated");
			}
		} 
		else {
			throw new InvalidAccountNumberException(
					"No record found for this account no: " + transferRequest.getToAccount());
		}

		return "Amount transfered successfully";
	}
	
	
}
