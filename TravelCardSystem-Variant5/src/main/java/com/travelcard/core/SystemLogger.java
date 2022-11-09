package com.travelcard.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SystemLogger {
	
	
	private static Logger log;

	
	private FileHandler fileTxt;
	
	
	private SimpleFormatter formatterTxt;

	
	private String logfilename = "Logfile.txt";

	
	public SystemLogger() {
		this.setLogfilename("Logfile.txt");
		log = Logger.getLogger("Travel Card Example Logger");
		log.setLevel(Level.ALL);
		setup();
	}

	
	
	
	
	public SystemLogger(String filename) {
		this.setLogfilename(filename);
		log = Logger.getLogger("Travel Card Example Logger");
		log.setLevel(Level.ALL);
	}

	
	
	
	
	public boolean exists(String filename) {
	
		File tmpDir = new File(filename);

		if (tmpDir.exists()) {

			return true;
		}
		return false;
	}

	
	
	
	
	public String getLogfilename() {
		return logfilename;
	}

	
	
	
	
	public Logger getLogger() {
		if (log == null) {
			log = Logger.getLogger("Travel Card Example Logger");
			log.setLevel(Level.ALL);
		}
		return log;
	}

	
	
	
	
	public void logContains(String checkedInSuccess) {
		readlog(checkedInSuccess);

	}

	
	
	
	
	public void printLog() {
		try {

			if (fileTxt == null) {
				fileTxt = new FileHandler(logfilename);
			} else {

				// create a TXT formatter
				formatterTxt = new SimpleFormatter();
				fileTxt.setFormatter(formatterTxt);
				log.addHandler(fileTxt);

			}

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	
	
	
	public boolean readlog(String msg) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(logfilename));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String strLine;

		/* read log line by line */
		try {
			while ((strLine = br.readLine()) != null) {
				if (strLine.equals(msg)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	
	
	public void setLogfilename(String logfilename) {
		this.logfilename = logfilename;
	}

	
	
	
	
	public void setup() {
		printLog();

	}

}
