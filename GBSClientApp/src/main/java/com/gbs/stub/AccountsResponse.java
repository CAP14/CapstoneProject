package com.gbs.stub;

import java.util.List;

import com.gbs.models.Accounts;

public class AccountsResponse {
	private List<Accounts> userAccount;

	public List<Accounts> getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(List<Accounts> userAccount) {
		this.userAccount = userAccount;
	}
}
