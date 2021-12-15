package com.gbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.entity.*;
import com.gbs.repository.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping("/transactionsResponse")
	public TransactionsResponse getAllTransactionsResponse() {
		List<Transactions> transactionsList = transactionRepository.findAll();
		TransactionsResponse transactionsResponse = new TransactionsResponse();
		transactionsResponse.setUserTransactions(transactionsList);
		return transactionsResponse;
	}

	@PostMapping("/transfer")
	public Transactions createTransaction(@RequestBody Transactions transactionFromBrowser) {
		Transactions newTransaction = transactionRepository.save(transactionFromBrowser);
		return newTransaction;
	}
}
