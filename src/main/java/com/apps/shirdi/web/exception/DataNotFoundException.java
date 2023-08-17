package com.apps.shirdi.web.exception;

import com.apps.shirdi.web.exception.error.ErrorCode;

public class DataNotFoundException extends Exception {
	
	private ErrorCode errorCode;

	public DataNotFoundException(String message) {
		super(message);
		
	}
	public DataNotFoundException(String message,ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
		
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	

}
