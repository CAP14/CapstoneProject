package com.gbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.entity.*;
import com.gbs.repository.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	@Autowired
	AccountsRepository accountsRepository;

	@GetMapping("/all")
	public AccountsResponse getAllAccountsResponse() {
		List<Accounts> accountsList = accountsRepository.findAll();
		AccountsResponse accountsResponse = new AccountsResponse();
		accountsResponse.setUserAccount(accountsList);
		return accountsResponse;
	}

	@PutMapping("/update/{id}")
	public Accounts updateAccount(@PathVariable(value = "id") String userAccNumber,
			@RequestBody Accounts accountFromBrowser) {

		Accounts existingAccount = accountsRepository.findById(userAccNumber).get();
		existingAccount.setAccBalance(accountFromBrowser.getAccBalance());
		Accounts updateAccount = accountsRepository.save(existingAccount);
		return updateAccount;
	}
}
