package com.travelcard.core;

public class ResponseObject {

	
	private int Code;
	
	
	private String issueMessage;

	
	private String message;

	public ResponseObject(int Code, String message) {
		super();
		this.Code = Code;
		this.message = message;
	}

	
	
	
	
	public int getCode() {
		return Code;
	}

	
	
	
	
	public String getIssueMessage() {
		return issueMessage;
	}

	
	
	
	
	public String getMessage() {
		return message;
	}

	
	
	
	
	public void setCode(int Code) {
		this.Code = Code;
	}

	
	
	
	
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
}
