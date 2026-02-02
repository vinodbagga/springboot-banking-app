package com.bagga.banking.mapper;

import com.bagga.banking.dtos.AccountDto;
import com.bagga.banking.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(accountDto.accountNumner(),accountDto.accountHolderName(),accountDto.balance());
		return account;
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getAccountNumber(),account.getAccountHolderName(),account.getBalance());
		return accountDto;
	}
}
