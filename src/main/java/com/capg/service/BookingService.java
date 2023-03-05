package com.capg.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.capg.entity.Booking;
import com.capg.exception.BookingNotFoundException;


public interface BookingService {
	
	public String addBooking(Booking booking);
	public List<Booking> listAllBookingsByuemail_Id(String uemail_Id);
	public List<Booking> listAllBookingsInDateRange(LocalDate startDate,LocalDate endDate) throws BookingNotFoundException;
	public Booking getBookingbyId(int bookingId) throws BookingNotFoundException;
	public String deleteBooking(int bookingId) throws BookingNotFoundException;
        public Booking updateBooking(Booking booking)throws BookingNotFoundException;
	
}
