package com.travelcard.core;

public class CheckOutAutomaton {

	
	private int counter = 0;
	
	
	private final int CONSTANT = 25;
	
	
	private Response response;
	
	
	private String stationName;

	
	public CheckOutAutomaton(String stationName) {
		this.setStationName(stationName);
	}

	
	
	
	
	public Response checkOut(Object argument) {
	
		if (argument.isTrue()) {
			CallMethod(argument);
			argument.setCheckedInStatus(false);
			response = new Response(230, Constants.CONSTANT5);

			InitSystem.isl.getLogger()
					.info("CHECKOUT: Automaton at " + stationName + " : " + Constants.CONSTANT5);
			InitSystem.isl.printLog();
			counter++;

		} else {

			response = new Response(240, Constants.CONSTANT4);
		
		}
		
		return response;
	}

	
	
	
	
	public void checkOutLog() {

		InitSystem.isl.logContains(Constants.CONSTANT5);

	}

	
	
	
	
	public String getStationName() {
		return stationName;
	}

	
	
	
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	
	
	
	
	private void CallMethod(Object argument) {

		argument.setValue(argument.getValue() - CONSTANT);

	}

	
	
	
}
