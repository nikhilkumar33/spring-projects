package com.kodewala.spring_core_xml_bean2;

public class Bank 
{
	private String accountNum;
	private String accountType;
	private String branch;
	public Bank(String accountNum, String accountType, String branch) {
		super();
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.branch = branch;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	

}
