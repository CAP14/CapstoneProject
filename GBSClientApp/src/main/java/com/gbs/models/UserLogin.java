package com.gbs.models;

import java.time.LocalDateTime;


public class UserLogin {

	private Long userID;
	private String userName;
	private String userPassword;
	LocalDateTime createDate = LocalDateTime.now();
	private int numberOfAccounts;
	private String accountNumberString;
	private Float totalBalance;
	private String contactNumber;

	public UserLogin() {
		super();
	}

	public UserLogin(Long userID, String userName, String userPassword, LocalDateTime createDate, int numberOfAccounts,
			String accountNumberString, Float totalBalance, String contactNumber) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.createDate = createDate;
		this.numberOfAccounts = numberOfAccounts;
		this.accountNumberString = accountNumberString;
		this.totalBalance = totalBalance;
		this.contactNumber = contactNumber;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}

	public String getAccountNumberString() {
		return accountNumberString;
	}

	public void setAccountNumberString(String accountNumberString) {
		this.accountNumberString = accountNumberString;
	}

	public Float getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Float totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}