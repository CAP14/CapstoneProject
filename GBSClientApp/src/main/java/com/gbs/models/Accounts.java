package com.gbs.models;


public class Accounts {
	private String userAccNumber;
	private String userName;
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
