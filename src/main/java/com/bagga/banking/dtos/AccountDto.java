package com.bagga.banking.dtos;

public record AccountDto(Long accountNumner, String accountHolderName, Double balance) {}

//public class AccountDto {
//
//	private Long  accountNumber;
//	private String accountHolderName;
//	private double balance;
//
//	public AccountDto() {
//	}
//
//	public AccountDto(Long accountNumber, String accountHolderName, double balance) {
//		super();
//		this.accountNumber = accountNumber;
//		this.accountHolderName = accountHolderName;
//		this.balance = balance;
//	}
//
//	public Long getAccountNumber() {
//		return accountNumber;
//	}
//
//	public void setAccountNumber(Long accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//
//	public String getAccountHolderName() {
//		return accountHolderName;
//	}
//
//	public void setAccountHolderName(String accountHolderName) {
//		this.accountHolderName = accountHolderName;
//	}
//
//	public double getBalance() {
//		return balance;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
//
//}
