package com.travelcard.core;

public class Object {
	
	
	private int balance;
	
	
	private boolean isCheckedInStatus;
	
	
	private String userID;

	
	public Object() {
	}

	
	
	
	
	public Object(int tcBalance) {
		this.balance = tcBalance;
	}

	
	
	
	
	public Object(String userIDnumber) {
		this.userID = userIDnumber;
	}

	
	
	
	
	public Object(String userID, int balance, boolean isCheckedInStatus) {
		this.userID = userID;
		this.balance = balance;
		this.isCheckedInStatus = isCheckedInStatus;
	}

	
	
	
	
	public void addBalance(int amount) {
		this.balance += amount;
		// TravelCardLogger.getLogger().info("new Travel card balance "+ balance);
	}

	
	
	
	
	public int getValue() {
		return balance;
	}

	
	
	
	
	public String getUserID() {
		return userID;
	}

	
	
	
	
	public boolean isTrue() {
		return isCheckedInStatus;
	}

	
	
	
	
	public void setValue(int balance) {
		this.balance = balance;
	}

	
	
	
	
	public void setCheckedInStatus(boolean isCheckedInStatus) {
		this.isCheckedInStatus = isCheckedInStatus;
	}

	
	
	
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	
	
	
	
}
