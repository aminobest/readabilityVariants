package com.travelcard.core;

public class CheckOutAutomaton {

	
	private int countCheckedOut = 0;
	
	
	private final int FARE = 25;
	
	
	private Ro response;
	
	
	private String stationName;

	
	public CheckOutAutomaton(String stationName) {
		this.setStationName(stationName);
	}

	
	
	
	
	public Ro checkOut(Tc card) {
	
		if (card.isACI()) {
			charge(card);
			card.setCI(false);
			response = new Ro(230, Const.CHECKED_OUT_SUCCESS);

			InitSystem.isl.getLogger()
					.info("CHECKOUT: Automaton at " + stationName + " : " + Const.CHECKED_OUT_SUCCESS);
			InitSystem.isl.printLog();
			countCheckedOut++;

		} else {

			response = new Ro(240, Const.CHECKED_OUT_FAILURE);
		
		}
		
		return response;
	}

	
	
	
	
	public void checkOutLog() {

		InitSystem.isl.logContains(Const.CHECKED_OUT_SUCCESS);

	}

	
	
	
	
	public String getStationName() {
		return stationName;
	}

	
	
	
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	
	
	
	
	private void charge(Tc card) {

		card.setBalance(card.getBalance() - FARE);

	}

	
	
	
}
