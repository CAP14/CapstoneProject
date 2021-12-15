package com.gbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ACCOUNTS")
public class Accounts {
	@Id
	@Column(name = "USERACCOUNT_NUMBER")
	private String userAccNumber;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "ACCOUNT_BALANCE")
	private float accBalance;

	public Accounts() {
		super();
	}

	public Accounts(String userAccNumber, String userName, float accBalance) {
		super();
		this.userAccNumber = userAccNumber;
		this.userName = userName;
		this.accBalance = accBalance;
	}

	public String getUserAccNumber() {
		return userAccNumber;
	}

	public void setUserAccNumber(String userAccNumber) {
		this.userAccNumber = userAccNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public float getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(float accBalance) {
		this.accBalance = accBalance;
	}

}
