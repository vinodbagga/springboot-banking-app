package com.bagga.banking.service;

import java.util.List;

import com.bagga.banking.dtos.AccountDto;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	List<AccountDto> getAllAccounts();
	AccountDto getAccountById(Long accountId);
	AccountDto deposit(Long accountId, double amount);
	AccountDto withdraw(Long accountId, double amount);
	void deleteAccount(Long accountId);
}
