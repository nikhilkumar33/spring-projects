package com.payment.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.transaction.entity.AccountEntity;
import com.payment.transaction.repository.AccountRepository;
import com.payment.transaction.request.AccountRequest;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public int createAccount(AccountRequest accountRequest) {
		AccountEntity accountEntity = new AccountEntity();
		
		accountEntity.setAccountNo(accountRequest.getAccountNo());
		accountEntity.setBalance(accountRequest.getBalance());
		accountEntity.setBranch(accountRequest.getBranch());
		accountEntity.setPassword(accountRequest.getPassword());
		
		accountEntity = accountRepository.save(accountEntity);
		return accountEntity.getId();
	}

}
