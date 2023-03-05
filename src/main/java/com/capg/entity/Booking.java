package com.capg.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	private String seatNumber;
	

	private LocalDate bookingDate;
	
	private String bookingAddress;
	
	private int duration;
	
	private String uemail_Id;
	
	private String bookingStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "u_id", referencedColumnName = "uId")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "a_id", referencedColumnName = "aId")
	private Admin admin;
	
	
	public Booking(int bookingId, String seatNumber, LocalDate bookingDate, String bookingAddress, int duration,
			String uemail_Id,String bookingStatus, User user) {
		super();
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.bookingDate = bookingDate;
		this.bookingAddress = bookingAddress;
		this.duration = duration;
		this.uemail_Id = uemail_Id;
		this.bookingStatus = bookingStatus;
		this.user = user;
	}




}
