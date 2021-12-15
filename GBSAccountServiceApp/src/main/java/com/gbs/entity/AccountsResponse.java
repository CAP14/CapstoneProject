package com.gbs.entity;

import java.util.List;

public class AccountsResponse {
	private List<Accounts> userAccount;

	public List<Accounts> getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(List<Accounts> userAccount) {
		this.userAccount = userAccount;
	}
}
