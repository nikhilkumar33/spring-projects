package com.kodewala.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Account
{
	@Value("5513105100288")
	private String accountNumber;
	@Value("sbi")
	private String branch;
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", branch=" + branch + "]";
	}
}