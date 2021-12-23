package com.gbs.stub;

import java.util.List;

import com.gbs.models.Transactions;

public class TransactionsResponse {
	private List<Transactions> userTransactions;

	public List<Transactions> getUserTransactions() {
		return userTransactions;
	}

	public void setUserTransactions(List<Transactions> userTransactions) {
		this.userTransactions = userTransactions;
	}
}
