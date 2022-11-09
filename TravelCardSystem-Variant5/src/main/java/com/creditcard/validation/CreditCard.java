package com.creditcard.validation;

public class CreditCard {

	
	private int balance;
	
	
	private CreditCardCompany cardType;

	
	private int chargedAmount;
	
	
	private String creditCardNumber;
	
	
	private boolean creditCardSuccessfullyCharged;
	
	
	private boolean valid;

	
	public CreditCard(String ccNumber) {
		this.creditCardNumber = ccNumber;
	}

	
	
	
	
	public void chargeSpecificAmountToTheCard(int amount) {
		this.setChargedAmount(amount);
		if (getServiceCreditCardBalance() - amount >= 0) {
			setCreditCardSuccessfullyCharged(true);
		} else
			setCreditCardSuccessfullyCharged(false);
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

	
	
	
	
	public boolean isCreditCardSuccessfullyCharged() {
		return creditCardSuccessfullyCharged;
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

	
	
	
	
	public void setCreditCardSuccessfullyCharged(boolean creditCardSuccessfullyCharged) {
		this.creditCardSuccessfullyCharged = creditCardSuccessfullyCharged;
	}

	
	
	
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	
	
	
	
	private int getServiceCreditCardBalance() {
		// communication with Bank to get credit card balance
		return this.balance;
	}

}
