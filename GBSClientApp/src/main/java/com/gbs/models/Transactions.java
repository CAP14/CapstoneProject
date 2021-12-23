package com.gbs.models;

import java.time.LocalDateTime;


public class Transactions {
	private long transactionID;
	private String fromAcc;
	private String toAcc;
	private float amount;
	LocalDateTime createDate = LocalDateTime.now();

	public Transactions() {
		super();
	}

	public Transactions(long transactionID, String fromAcc, String toAcc, float amount, LocalDateTime createDate) {
		super();
		this.transactionID = transactionID;
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
		this.createDate = createDate;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public String getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(String fromAcc) {
		this.fromAcc = fromAcc;
	}

	public String getToAcc() {
		return toAcc;
	}

	public void setToAcc(String toAcc) {
		this.toAcc = toAcc;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Transactions [transactionID=" + transactionID + ", fromAcc=" + fromAcc + ", toAcc=" + toAcc
				+ ", amount=" + amount + ", createDate=" + createDate + "]";
	}

}
