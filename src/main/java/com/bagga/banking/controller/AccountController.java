package com.bagga.banking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bagga.banking.dtos.AccountDto;
import com.bagga.banking.service.AccountService;

@RestController
@RequestMapping("/bank/api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/create")
	public ResponseEntity<AccountDto> createNewAccount(@RequestBody AccountDto accountDto) {
		AccountDto account = accountService.createAccount(accountDto);
		return new ResponseEntity<>(account, HttpStatus.CREATED);
	}
	
	// professional style API
	@GetMapping("/list")
	public ResponseEntity<List<AccountDto>> getAccounts(){
		List<AccountDto> listOfAccounts = accountService.getAllAccounts();
		if(listOfAccounts.isEmpty()) {
			return ResponseEntity.noContent().build(); // 204 status 
		}
		return ResponseEntity.ok(listOfAccounts);
	}
	

	
	//Custom response message (Enterprise style)	
	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> getListOfAccounts(){
		List<AccountDto> list = accountService.getAllAccounts();
		Map<String, Object> response = new HashMap<>();
		response.put("count", list.size());
		response.put("data", list);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/customerid/{accountId}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long accountId){
		AccountDto accountDto  = accountService.getAccountById(accountId);
		return ResponseEntity.ok(accountDto);
	}
	@PutMapping("/deposit/{accountId}")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long accountId, @RequestBody Map<String, Double> request){
		AccountDto accountDto = accountService.deposit(accountId, request.get("amount"));
		return ResponseEntity.ok(accountDto);
		
	}
	@PutMapping("/withdraw/{accountId}")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long accountId, @RequestBody Map<String, Double> request){
		AccountDto accountDto = accountService.withdraw(accountId, request.get("amount"));
		return ResponseEntity.ok(accountDto);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount( @PathVariable(name="id") Long accountId){
		accountService.deleteAccount(accountId);
		return ResponseEntity.ok("Account number "+accountId+" Deleted Successfully.....");
	}

//	@GetMapping("/all")
//	public ResponseEntity<List<AccountDto>> getAllAccounts() {
//		List<AccountDto> accounts = accountService.getAllAccounts();
//		return ResponseEntity.ok(accounts);
//	}
//	
	@GetMapping("/list")
	public List<AccountDto> getAllAccountsList() {
	    return accountService.getAllAccounts();
	}
	

}
