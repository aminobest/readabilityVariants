package com.creditcard.validation;

public class CreditCard {

	
	private int balance;
	
	
	private CreditCardCompany cardType;

	
	private int chargedAmount;
	
	
	private String creditCardNumber;
	
	
	private boolean successfullyCharged;
	
	
	private boolean valid;

	
	public CreditCard(String ccNumber) {
		this.creditCardNumber = ccNumber;
	}

	
	
	
	
	public void charge(int amount) {
		this.setChargedAmount(amount);
		if (getServiceCreditCardBalance() - amount >= 0) {
			setSuccessfullyCharged(true);
		} else
			setSuccessfullyCharged(false);
	}

	
	
	
	
	public int getBalance() {
		return this.balance;

	}

	
	
	
	
	public CreditCardCompany getCardType() {
		return cardType;
	}

	
	
	
	
	public int getChargedAmount() {
		return this.chargedAmount;
	}

	
	
	
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	
	
	
	
	public boolean isSuccessfullyCharged() {
		return successfullyCharged;
	}

	
	
	
	
	public boolean isValid() {
		return valid;
	}

	
	
	
	
	public void setBalance(int amount) {
		this.balance = amount;

	}

	
	
	
	
	public void setCardType(CreditCardCompany cardType) {
		this.cardType = cardType;
	}
	
	
	
	

	public void setChargedAmount(int chargedAmount) {
		this.chargedAmount = chargedAmount;
	}

	
	
	
	
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	
	
	
	
	public void setSuccessfullyCharged(boolean successfullyCharged) {
		this.successfullyCharged = successfullyCharged;
	}

	
	
	
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	
	
	
	
	private int getServiceCreditCardBalance() {
		// communication with Bank to get credit card balance
		return this.balance;
	}

}
