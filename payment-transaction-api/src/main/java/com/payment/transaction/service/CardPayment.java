package com.payment.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.transaction.entity.AccountEntity;
import com.payment.transaction.exception.InactiveAccountException;
import com.payment.transaction.exception.InsufficientBalanceException;
import com.payment.transaction.exception.InvalidAccountNumberException;
import com.payment.transaction.repository.PaymentRepository;
import com.payment.transaction.request.PaymentRequest;

import jakarta.transaction.Transactional;

@Service("card")
public class CardPayment implements PaymentService
{

	@Autowired
	PaymentRepository paymentRepository;
	
	@Transactional
	@Override
	public String processPayment(PaymentRequest paymentRequest) {
		String fromAccount = paymentRequest.getFromAccount();
		String toAccount = paymentRequest.getToAccount();
		double amountToBeTrans = paymentRequest.getAmount();
		
		AccountEntity fromAccountData = paymentRepository.findByAccountNo(fromAccount);
		if(fromAccountData == null) {
			throw new InvalidAccountNumberException("Incorrect account no: "+fromAccount);
		}
		else if(! fromAccountData.getStatus().equals("A")) {
			throw new InactiveAccountException("Account is inactive.. "+fromAccount);
		}
		else if(fromAccountData.getBalance()< amountToBeTrans) {
			throw new InsufficientBalanceException("You donot have sufficient balance for this transaction amount: "+amountToBeTrans);
		}
		fromAccountData.setBalance(fromAccountData.getBalance()-amountToBeTrans);
		paymentRepository.save(fromAccountData);
		
		AccountEntity toAccountData = paymentRepository.findByAccountNo(toAccount);
		if(toAccountData == null) {
			throw new InvalidAccountNumberException("Incorrect account no: "+toAccount);
		}
		else if(! toAccountData.getStatus().equals("A")) {
			throw new InactiveAccountException("Account is inactive.. "+toAccount);
		}
		toAccountData.setBalance(toAccountData.getBalance() + amountToBeTrans);
		paymentRepository.save(toAccountData);
		return "Payment Successfully done using Card..";
	}

}
