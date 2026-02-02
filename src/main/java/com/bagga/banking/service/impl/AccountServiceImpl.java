package com.bagga.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagga.banking.dtos.AccountDto;
import com.bagga.banking.entity.Account;
import com.bagga.banking.exceptions.InsufficientBalanceException;
import com.bagga.banking.exceptions.ResourceNotFoundException;
import com.bagga.banking.mapper.AccountMapper;
import com.bagga.banking.repository.AccountRepository;
import com.bagga.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account acountObj = AccountMapper.mapToAccount(accountDto);
		return AccountMapper.mapToAccountDto(accountRepo.save(acountObj));
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		return accountRepo.findAll().stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
	}

	@Override
	public AccountDto getAccountById(Long accountId) {
		Account account = accountRepo.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account number " + accountId + " does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long accountId, double amount) {
		Account account = accountRepo.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account number " + accountId + " does not exist"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long accountId, double withdrawAmount) {
		if (withdrawAmount <= 0) {
			throw new InsufficientBalanceException("Withdrawal amount must be greater than zero");
		}
		if (withdrawAmount <= 0) {
			throw new InsufficientBalanceException("Withdrawal amount must be greater than zero");
		}

		Account account = accountRepo.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account Number " + accountId + " does not exist"));

		if (withdrawAmount > account.getBalance()) {
			throw new InsufficientBalanceException("Insufficient balance. Available balance: " + account.getBalance());
		}

		double totalAmount = account.getBalance() - withdrawAmount;
		account.setBalance(totalAmount);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public void deleteAccount(Long accountId) {
		Account account = accountRepo.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account number " + accountId + " does not exist"));
		accountRepo.deleteById(accountId);
	}

}
