package com.capg.entity;
import java.sql.Date;
import java.time.LocalDate;

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
public class Bookingdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingdetailsId;
	
	private String bookingStatus;
	
	private Long duration;
	

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	private String uemailId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "a_id", referencedColumnName = "aId")
	private Admin admin;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "booking_id", referencedColumnName = "bookingId")
	private Booking booking;


	public Bookingdetails(int bookingdetailsId, String bookingStatus, Long duration, LocalDate date, String uemailId,
			Admin admin, Booking booking) {
		super();
		this.bookingdetailsId = bookingdetailsId;
		this.bookingStatus = bookingStatus;
		this.duration = duration;
		this.date = date;
		this.uemailId = uemailId;
		this.admin = admin;
		this.booking = booking;
	}



}
