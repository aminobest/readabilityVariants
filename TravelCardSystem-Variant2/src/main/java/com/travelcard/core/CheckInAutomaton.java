package com.travelcard.core;

public class CheckInAutomaton {

	
	private int countCheckIn = 0;
	
	
	private final int MINIMUM_CHECKIN_BALANCE = 25;
	
	
	private Response response;
	
	
	private String stationName;

	
	public CheckInAutomaton(String stationName) {
		this.stationName = stationName;

	}
	
	
	
	

	public Response checkIn(Object card) {
		
		if (!card.isTrue()) {
		
			if (hasEnoughBalance(card)) {
				card.setCheckedInStatus(true);
				response = new Response(200, Constants.CONSTANT3);

				InitSystem.isl.getLogger()
						.info("CHECKIN: Automaton at " + stationName + " : " + Constants.CONSTANT3);
				InitSystem.isl.printLog();
				countCheckIn++;
			
			} else {
			
				response = new Response(220, Constants.CONSTANT2);
			
			}
			
		} else {
			
			response = new Response(210, Constants.CONSTANT1);
		
		}
		
		return response;
	}

	
	
	
	
	public void checkInLog() {
		InitSystem.isl.logContains(Constants.CONSTANT3);
	}

	
	
	
	
	public String getStationName() {
		return stationName;
	}

	
	
	
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	
	
	
	
	private boolean hasEnoughBalance(Object card) {
		return card.getValue() > MINIMUM_CHECKIN_BALANCE;
	}

	
	
	
	
}
