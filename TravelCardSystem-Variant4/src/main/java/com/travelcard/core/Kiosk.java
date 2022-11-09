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

	
	
	public Boolean checkUser(TravelCard user) {
		if(tcUsers.contains(user)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	private final int FARE_TRAVEL_CARD_CREATION = 100;

	
	private CreditCard insertedCC;
	
	
	private ResponseObject response;
	
	
	private String stationName;
	
	
	private List<TravelCard> tcUsers;

	
	private String textOnScreen;

	
	public Kiosk(String stationName) {
		this.setStationName(stationName);
		tcUsers = new ArrayList<TravelCard>();
		TravelCardUserList tcu = new TravelCardUserList();
		tcUsers = tcu.getUserIDs();
	}

	

	
	public ResponseObject addBalance(TravelCard tcInUse, int amount) {
	
		if (verify(insertedCC).getCode() == 530) {
			
			insertedCC.isCharged(amount);
		
			if (insertedCC.charge()) {
			
				response = new ResponseObject(300, Constants.RELOAD_SUCCESS);
				tcInUse.addBalance(amount);
				InitSystem.isl.getLogger().info("CREDIT CARD :" + Constants.VALID_CC + Constants.RELOAD_SUCCESS);
				InitSystem.isl.printLog();
			
			} else {
			
				response = new ResponseObject(320, Constants.INVALID_CC_LOW_BALANCE);
			
			}
		
		}
		
		return response;

	}

	
	
	
	public void checkRegistered() {
		InitSystem.isl.logContains(Constants.VALID_CC + Constants.TRAVEL_CARD_CREATION_SUCCESS);

	}

	
	
	
	
	public void checkReload() {
		InitSystem.isl.logContains(Constants.VALID_CC + Constants.RELOAD_SUCCESS);

	}

	
	
	
	
	public CreditCard getInsertedCC() {
		return insertedCC;
	}

	
	
	
	
	public String getStationName() {
		return stationName;
	}

	
	
	
	
	public List<TravelCard> getTcUsers() {
		return tcUsers;
	}

	
	
	
	
	public String getTextOnScreen() {
		return textOnScreen;
	}

	
	
	
	
	public ResponseObject issueTravelCard(TravelCard user) {

		if (!checkUser(user)) {
	
			insertedCC.isCharged(FARE_TRAVEL_CARD_CREATION);
			
			if (insertedCC.charge()) {

				tcUsers.add(user);
				response = new ResponseObject(400, Constants.TRAVEL_CARD_CREATION_SUCCESS);
				InitSystem.isl.getLogger()
						.info("CREDIT CARD :" + Constants.VALID_CC + Constants.TRAVEL_CARD_CREATION_SUCCESS);
				InitSystem.isl.printLog();

			} else {
			
				response = new ResponseObject(420, Constants.INVALID_CC_LOW_BALANCE);
			
			}

		} else{
		
			response = new ResponseObject(410, Constants.TRAVEL_CARD_CREATION_FAILURE);
		
		}
		
		return response;
	
	}

	


	public void setInsertedCC(CreditCard insertedCC) {
		this.insertedCC = insertedCC;
	}

	
	
	
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	
	
	
	
	public void setTcUsers(List<TravelCard> tcUsers) {
		this.tcUsers = tcUsers;
	}

	
	
	
	
	public void setTextOnScreen(String textOnScreen) {
		this.textOnScreen = textOnScreen;
	}

	
	
	
	
	public ResponseObject verify(CreditCard creditCard) {
	
		String cardNumber = creditCard.getCreditCardNumber().replaceAll("[^0-9]+", "");
		
		if ((cardNumber == null) || (cardNumber.length() < 13) || (cardNumber.length() > 19)) {
		
			this.textOnScreen = Constants.INVALID_CC_LENGTH;

			return new ResponseObject(500, Constants.INVALID_CC_LENGTH);
		
		}

		if (!luhnCheck(cardNumber)) {
	
			this.textOnScreen = Constants.INVALID_CC_LETTERS;
		
			return new ResponseObject(510, Constants.INVALID_CC_LETTERS);
		
		}

		CreditCardCompany cc = CreditCardCompany.obtainCompany(cardNumber);
		
		if (cc == null) {
		
			this.textOnScreen = Constants.INVALID_CC_COMPANY;

			return new ResponseObject(520, Constants.INVALID_CC_COMPANY);
		
		}

		this.textOnScreen = Constants.VALID_CC;
		setInsertedCC(creditCard);

		return new ResponseObject(530, Constants.VALID_CC);

	}

}
