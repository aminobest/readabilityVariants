package com.travelcard.core;

import java.util.ArrayList;
import java.util.List;
import com.creditcard.validation.CreditCard;
import com.creditcard.validation.CreditCardCompany;

public class Kiosk {

	
	/**
	 * Checks for a valid credit card number.
	 * 
	 * @param cardNumber
	 *            Credit Card Number.
	 * @return Whether the card number passes the luhnCheck.
	 */
	
	
	private static boolean luhnCheck(String cardNumber) {
		// number must be validated as 0..9 numeric first!!
		int digits = cardNumber.length();
		int oddOrEven = digits & 1;
		long sum = 0;
		for (int count = 0; count < digits; count++) {
			int digit = 0;
			try {
				digit = Integer.parseInt(cardNumber.charAt(count) + "");
			} catch (NumberFormatException e) {
				return false;
			}

			if (((count & 1) ^ oddOrEven) == 0) { // not
				digit *= 2;
				if (digit > 9) {
					digit -= 9;
				}
			}
			sum += digit;
		}

		return (sum == 0) ? false : (sum % 10 == 0);
	}

	
	
	
	
	private final int FARE_TRAVEL_CARD_CREATION = 100;

	
	private CreditCard insertedCC;
	
	
	private Ro response;
	
	
	private String stationName;
	
	
	private List<Tc> tcUsers;

	
	private String textOnScreen;

	
	public Kiosk(String stationName) {
		this.setStationName(stationName);
		tcUsers = new ArrayList<Tc>();
		TravelCardUserList tcu = new TravelCardUserList();
		tcUsers = tcu.getUserIDs();
	}

	
	
	
	
	public Ro addBalance(Tc tcInUse, int amount) {
	
		if (verify(insertedCC).getCode() == 530) {
			
			insertedCC.charge(amount);
		
			if (insertedCC.isSuccessfullyCharged()) {
			
				response = new Ro(300, Const.RELOAD_SUCCESS);
				tcInUse.addBalance(amount);
				InitSystem.isl.getLogger().info("CREDIT CARD :" + Const.VALID_CC + Const.RELOAD_SUCCESS);
				InitSystem.isl.printLog();
			
			} else {
			
				response = new Ro(320, Const.INVALID_CC_LOW_BALANCE);
			
			}
		
		}
		
		return response;

	}

	
	
	
	public void checkRegistered() {
		InitSystem.isl.logContains(Const.VALID_CC + Const.TRAVEL_CARD_CREATION_SUCCESS);

	}

	
	
	
	
	public void checkReload() {
		InitSystem.isl.logContains(Const.VALID_CC + Const.RELOAD_SUCCESS);

	}

	
	
	
	
	public CreditCard getInsertedCC() {
		return insertedCC;
	}

	
	
	
	
	public String getStationName() {
		return stationName;
	}

	
	
	
	
	public List<Tc> getTcUsers() {
		return tcUsers;
	}

	
	
	
	
	public String getTextOnScreen() {
		return textOnScreen;
	}

	
	
	
	
	public Ro issueTravelCard(Tc user) {

		if (!tcUsers.contains(user)) {
	
			insertedCC.charge(FARE_TRAVEL_CARD_CREATION);
			
			if (insertedCC.isSuccessfullyCharged()) {

				tcUsers.add(user);
				response = new Ro(400, Const.TRAVEL_CARD_CREATION_SUCCESS);
				InitSystem.isl.getLogger()
						.info("CREDIT CARD :" + Const.VALID_CC + Const.TRAVEL_CARD_CREATION_SUCCESS);
				InitSystem.isl.printLog();

			} else {
			
				response = new Ro(420, Const.INVALID_CC_LOW_BALANCE);
			
			}

		} else{
		
			response = new Ro(410, Const.TRAVEL_CARD_CREATION_FAILURE);
		
		}
		
		return response;
	
	}

	
	
	
	
	public void setInsertedCC(CreditCard insertedCC) {
		this.insertedCC = insertedCC;
	}

	
	
	
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	
	
	
	
	public void setTcUsers(List<Tc> tcUsers) {
		this.tcUsers = tcUsers;
	}

	
	
	
	
	public void setTextOnScreen(String textOnScreen) {
		this.textOnScreen = textOnScreen;
	}

	
	
	
	
	public Ro verify(CreditCard creditCard) {
	
		String cardNumber = creditCard.getCreditCardNumber().replaceAll("[^0-9]+", "");
		
		if ((cardNumber == null) || (cardNumber.length() < 13) || (cardNumber.length() > 19)) {
		
			this.textOnScreen = Const.INVALID_CC_LENGTH;

			return new Ro(500, Const.INVALID_CC_LENGTH);
		
		}

		if (!luhnCheck(cardNumber)) {
	
			this.textOnScreen = Const.INVALID_CC_LETTERS;
		
			return new Ro(510, Const.INVALID_CC_LETTERS);
		
		}

		CreditCardCompany cc = CreditCardCompany.obtainCompany(cardNumber);
		
		if (cc == null) {
		
			this.textOnScreen = Const.INVALID_CC_COMPANY;

			return new Ro(520, Const.INVALID_CC_COMPANY);
		
		}

		this.textOnScreen = Const.VALID_CC;
		setInsertedCC(creditCard);

		return new Ro(530, Const.VALID_CC);

	}

}
