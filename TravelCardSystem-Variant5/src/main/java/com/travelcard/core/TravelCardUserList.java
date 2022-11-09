package com.travelcard.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.travelcard.datagenerator.util.RandomTravelCardUsers;

public class TravelCardUserList {

	
	private List<TravelCard> users;

	
	public TravelCardUserList() {
		users = new ArrayList<TravelCard>();
		RandomTravelCardUsers rru = new RandomTravelCardUsers();
		users = rru.generate(10);

	}

	
	
	
	
	public void addUserID(TravelCard newUserID) {
		users.add(newUserID);

	}

	
	
	
	
	public void generateNameList() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(Constants.REPORT_USER_LIST, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		for (TravelCard u : users) {
			writer.println(u.getUserID());

		}
		writer.close();

	}

	
	
	
	
	public List<TravelCard> getUserIDs() {
		return users;
	}

	
	
	
	
	public boolean reportExists(String reportName) {
		File tmpDir = new File(reportName);
		return tmpDir.exists();
	}

	
	
	
	
	public void setuserIDs(List<TravelCard> users) {
		this.users = users;
	}

	
	
	
	
}
