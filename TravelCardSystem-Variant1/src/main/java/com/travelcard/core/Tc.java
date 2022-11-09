package com.travelcard.core;

public class Tc {
	
	
	private int balance;
	
	
	private boolean isCheckedInStatus;
	
	
	private String userID;

	
	public Tc() {
	}

	
	
	
	
	public Tc(int tcBalance) {
		this.balance = tcBalance;
	}

	
	
	
	
	public Tc(String userIDnumber) {
		this.userID = userIDnumber;
	}

	
	
	
	
	public Tc(String userID, int balance, boolean isCheckedInStatus) {
		this.userID = userID;
		this.balance = balance;
		this.isCheckedInStatus = isCheckedInStatus;
	}

	
	
	
	
	public void addBalance(int amount) {
		this.balance += amount;
		// TravelCardLogger.getLogger().info("new Travel card balance "+ balance);
	}

	
	
	
	
	public int getBalance() {
		return balance;
	}

	
	
	
	
	public String getUserID() {
		return userID;
	}

	
	
	
	
	public boolean isACI() {
		return isCheckedInStatus;
	}

	
	
	
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	
	
	
	public void setCI(boolean isCheckedInStatus) {
		this.isCheckedInStatus = isCheckedInStatus;
	}

	
	
	
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	
	
	
	
}
