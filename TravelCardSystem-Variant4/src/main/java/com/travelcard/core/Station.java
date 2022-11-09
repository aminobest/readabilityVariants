package com.travelcard.core;

public class Station {

	
	private CheckInAutomaton checkIn;
	
	
	private CheckOutAutomaton checkOut;
	
	
	private int countCheckIn;
	
	
	private int countCheckOut;
	
	
	private Kiosk kiosk;

	
	private String stationName;

	
	public Station(String stationName) {
		super();
		this.stationName = stationName;
	}

	
	
	
	
	public CheckInAutomaton getCheckIn() {
		return checkIn;
	}

	
	
	
	
	public CheckOutAutomaton getCheckOut() {
		return checkOut;
	}

	
	
	
	
	public int getCountCheckIn() {
		return countCheckIn;
	}

	
	
	
	
	public int getCountCheckOut() {
		return countCheckOut;
	}

	
	
	
	
	public Kiosk getKiosk() {
		return kiosk;
	}

	
	
	
	
	public String getStationName() {
		return stationName;
	}

	
	
	
	
	public void setCheckIn(CheckInAutomaton checkIn) {
		this.checkIn = checkIn;
	}

	
	
	
	
	public void setCheckOut(CheckOutAutomaton checkOut) {
		this.checkOut = checkOut;
	}

	
	
	
	
	public void setCountCheckIn(int countCheckIn) {
		this.countCheckIn = countCheckIn;
	}

	
	
	
	
	public void setCountCheckOut(int countCheckOut) {
		this.countCheckOut = countCheckOut;
	}

	
	
	
	
	public void setKiosk(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	
	
	
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	
	
	
}
