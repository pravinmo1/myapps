package com.apps.shirdi.web.exception.error;

public enum ErrorCode {
	
	USER_NOT_FOUND(1001);
	
	private final int code;
	
	ErrorCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	

}
