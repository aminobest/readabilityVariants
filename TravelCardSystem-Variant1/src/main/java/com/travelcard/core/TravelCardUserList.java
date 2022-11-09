package com.travelcard.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.travelcard.datagenerator.util.RandomTravelCardUsers;

public class TravelCardUserList {

	
	private List<Tc> users;

	
	public TravelCardUserList() {
		users = new ArrayList<Tc>();
		RandomTravelCardUsers rru = new RandomTravelCardUsers();
		users = rru.generate(10);

	}

	
	
	
	
	public void addUserID(Tc newUserID) {
		users.add(newUserID);

	}

	
	
	
	
	public void generateNameList() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(Const.REPORT_USER_LIST, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		for (Tc u : users) {
			writer.println(u.getUserID());

		}
		writer.close();

	}

	
	
	
	
	public List<Tc> getUserIDs() {
		return users;
	}

	
	
	
	
	public boolean reportExists(String reportName) {
		File tmpDir = new File(reportName);
		return tmpDir.exists();
	}

	
	
	
	
	public void setuserIDs(List<Tc> users) {
		this.users = users;
	}

	
	
	
	
}
