package com.capg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * Table containing seat data
 *
 */
@Data
@NoArgsConstructor
@Entity
public class Seat {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;
	
	private String seatNumber;
	
	private String seatLocation;

	private int seatFloor;

	private int floorCapacity;

	private boolean isBooked;
	
	private int seatsAvailable;
	
	private String emailId;
	
	
	@OneToOne
	@JoinColumn(name = "u_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="a_id")
	private Admin admin;


	public Seat(int seatId, String seatNumber, String seatLocation, int seatFloor, int floorCapacity, boolean isBooked,
			int seatsAvailable, String emailId,User user, Admin admin) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.seatLocation = seatLocation;
		this.seatFloor = seatFloor;
		this.floorCapacity = floorCapacity;
		this.isBooked = isBooked;
		this.seatsAvailable = seatsAvailable;
		this.emailId = emailId;
		this.user=user;
		this.admin = admin;
	}


}





////@OneToOne(cascade=CascadeType.ALL)
//@OneToOne
//@JoinColumn(name = "u_id", referencedColumnName = "uId")
//private User user;


//@ManyToOne(cascade = CascadeType.ALL)
	//@ManyToOne
	//@JoinColumn(name = "a_id", referencedColumnName = "aId")
	//@JoinColumn(name="a_id")
	//private Admin admin;
