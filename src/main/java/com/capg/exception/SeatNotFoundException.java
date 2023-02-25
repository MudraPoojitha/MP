package com.capg.exception;

public class SeatNotFoundException extends RuntimeException{
	String msg;
	
	public SeatNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}

}
