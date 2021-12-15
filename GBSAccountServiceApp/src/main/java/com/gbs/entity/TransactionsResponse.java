package com.gbs.entity;

import java.util.List;

public class TransactionsResponse {
	private List<Transactions> userTransactions;

	public List<Transactions> getUserTransactions() {
		return userTransactions;
	}

	public void setUserTransactions(List<Transactions> userTransactions) {
		this.userTransactions = userTransactions;
	}
}
