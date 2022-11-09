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
	
	
	private Response response;
	
	
	private String stationName;
	
	
	private List<Object> tcUsers;

	
	private String textOnScreen;

	
	public Kiosk(String stationName) {
		this.setStationName(stationName);
		tcUsers = new ArrayList<Object>();
		TravelCardUserList tcu = new TravelCardUserList();
		tcUsers = tcu.getUserIDs();
	}

	
	
	
	
	public Response addBalance(Object tcInUse, int amount) {
	
		if (verify(insertedCC).getCode() == 530) {
			
			insertedCC.charge(amount);
		
			if (insertedCC.isSuccessfullyCharged()) {
			
				response = new Response(300, Constants.CONSTANT12);
				tcInUse.addBalance(amount);
				InitSystem.isl.getLogger().info("CREDIT CARD :" + Constants.CONSTANT17 + Constants.CONSTANT12);
				InitSystem.isl.printLog();
			
			} else {
			
				response = new Response(320, Constants.CONSTANT9);
			
			}
		
		}
		
		return response;

	}

	
	
	
	public void checkRegistered() {
		InitSystem.isl.logContains(Constants.CONSTANT17 + Constants.CONSTANT16);

	}

	
	
	
	
	public void checkReload() {
		InitSystem.isl.logContains(Constants.CONSTANT17 + Constants.CONSTANT12);

	}

	
	
	
	
	public CreditCard getInsertedCC() {
		return insertedCC;
	}

	
	
	
	
	public String getStationName() {
		return stationName;
	}

	
	
	
	
	public List<Object> getTcUsers() {
		return tcUsers;
	}

	
	
	
	
	public String getTextOnScreen() {
		return textOnScreen;
	}

	
	
	
	
	public Response issueTravelCard(Object user) {

		if (!tcUsers.contains(user)) {
	
			insertedCC.charge(FARE_TRAVEL_CARD_CREATION);
			
			if (insertedCC.isSuccessfullyCharged()) {

				tcUsers.add(user);
				response = new Response(400, Constants.CONSTANT16);
				InitSystem.isl.getLogger()
						.info("CREDIT CARD :" + Constants.CONSTANT17 + Constants.CONSTANT16);
				InitSystem.isl.printLog();

			} else {
			
				response = new Response(420, Constants.CONSTANT9);
			
			}

		} else{
		
			response = new Response(410, Constants.CONSTANT15);
		
		}
		
		return response;
	
	}

	
	
	
	
	public void setInsertedCC(CreditCard insertedCC) {
		this.insertedCC = insertedCC;
	}

	
	
	
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	
	
	
	
	public void setTcUsers(List<Object> tcUsers) {
		this.tcUsers = tcUsers;
	}

	
	
	
	
	public void setTextOnScreen(String textOnScreen) {
		this.textOnScreen = textOnScreen;
	}

	
	
	
	
	public Response verify(CreditCard creditCard) {
	
		String cardNumber = creditCard.getCreditCardNumber().replaceAll("[^0-9]+", "");
		
		if ((cardNumber == null) || (cardNumber.length() < 13) || (cardNumber.length() > 19)) {
		
			this.textOnScreen = Constants.CONSTANT7;

			return new Response(500, Constants.CONSTANT7);
		
		}

		if (!luhnCheck(cardNumber)) {
	
			this.textOnScreen = Constants.CONSTANT8;
		
			return new Response(510, Constants.CONSTANT8);
		
		}

		CreditCardCompany cc = CreditCardCompany.obtainCompany(cardNumber);
		
		if (cc == null) {
		
			this.textOnScreen = Constants.CONSTANT6;

			return new Response(520, Constants.CONSTANT6);
		
		}

		this.textOnScreen = Constants.CONSTANT17;
		setInsertedCC(creditCard);

		return new Response(530, Constants.CONSTANT17);

	}

}
