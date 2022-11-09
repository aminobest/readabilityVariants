package com.travelcard.core;

public class CheckInAutomaton {

	
	private int i = 0; 
	
	
	private final int MCB = 25;
	
	
	private Ro response;
	
	
	private String stationName;

	
	public CheckInAutomaton(String stationName) {
		this.stationName = stationName;

	}
	

	public Ro checkIn(Tc c) {
		
		if (!c.isACI()) { 
		
			if (suff(c)) { 
				
				c.setCI(true); 
				response = new Ro(200, Const.CS); 

				InitSystem.isl.getLogger()
						.info("CHECKIN: Automaton at " + stationName + " : " + Const.CS); 
				InitSystem.isl.printLog();
				i++; 
			
			} else {
			
				response = new Ro(220, Const.CF_LB); 
			
			}
			
		} else {
			
			response = new Ro(210, Const.CF_ALRD); 
		
		}
		
		return response;
	}

	
	
	
	
	public void checkInLog() {
		InitSystem.isl.logContains(Const.CS);
	}

	
	
	
	
	public String getStationName() {
		return stationName;
	}

	
	
	
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	
	
	
	
	private boolean suff(Tc c) { 
		return c.getBalance() > MCB;
	}

	
	
	
	
}
