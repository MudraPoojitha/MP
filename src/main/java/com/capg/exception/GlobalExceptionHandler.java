package com.capg.exception;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;




@ControllerAdvice
public class GlobalExceptionHandler {

//	@ResponseBody
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	@ExceptionHandler({ Exception.class })

//	@Value(value="${message1}")
//	private String message1;
//	
//	@Value(value="${message2}")
//	private String message2;
//	
//	@Value(value="${message2}")
//	private String message2;
//	
////	@Value(value="${message4}")
////	private String message4;
//
//
//
	@Value(value="${message1}")
	private String message1;
	@ExceptionHandler(value=BookingNotFoundException.class)
	public ResponseEntity  bookingNotFoundException(BookingNotFoundException ex) {
		return new ResponseEntity(message1,HttpStatus.CONFLICT);
	}
//	public ExceptionErrorMapper handleConflict(Exception ex, HttpServletRequest req) {
//		String msg = ex.getMessage();
//		String uri = req.getRequestURL().toString();
//		return new ExceptionErrorMapper(uri, msg, new Date());
//	}
////	
//	@ExceptionHandler(value=ExceptionErrorMapper.class)
//	public ResponseEntity  exceptionErrorMapper(ExceptionErrorMapper ex) {
//		return new ResponseEntity(message2,HttpStatus.CONFLICT);
//	}
	@Value(value="${message2}")
	private String message2;
	
	@ExceptionHandler(value=SeatNotFoundException.class)
	public ResponseEntity  seatNotFoundException(SeatNotFoundException ex) {
		return new ResponseEntity(message2,HttpStatus.CONFLICT);
	}
//	
	@Value(value="${message3}")
	private String message3;
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity  UserNotFoundException(UserNotFoundException ex) {
		return new ResponseEntity(message3,HttpStatus.CONFLICT);
	}
	
}
