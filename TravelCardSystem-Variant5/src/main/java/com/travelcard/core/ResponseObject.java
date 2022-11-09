package com.travelcard.core;

public class ResponseObject {

	
	private int responseObjectCode;
	
	
	private String issueMessage;

	
	private String message;

	public ResponseObject(int Code, String message) {
		super();
		this.responseObjectCode = Code;
		this.message = message;
	}

	
	
	
	
	public int getResponseObjectCode() {
		return responseObjectCode;
	}

	
	
	
	
	public String getIssueMessage() {
		return issueMessage;
	}

	
	
	
	
	public String getMessage() {
		return message;
	}

	
	
	
	
	public void setResponseObjectCode(int Code) {
		this.responseObjectCode = Code;
	}

	
	
	
	
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
}
