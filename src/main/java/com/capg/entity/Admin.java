package com.capg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity 
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;

	private String adminName;
	
	private String emailId;
	
	private String username;
	
	private String password;
	
	private String role;

	//@OneToOne(cascade=CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "u_id", referencedColumnName = "uId")
	private User user;
	
	//@OneToMany(mappedBy = "admin" , fetch = FetchType.EAGER)
	//@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany
	@JoinColumn
	private List<Seat> seats;
	
	@OneToMany(mappedBy = "admin" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Bookingdetails> bookingdetails;
	

	public Admin(int aId, String adminName, String emailId, String username, String password, String role, User user,
			List<Seat> seats, List<Bookingdetails> bookingdetails) {
		super();
		this.aId = aId;
		this.adminName = adminName;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.user = user;
		this.seats = seats;
		this.bookingdetails = bookingdetails;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}



	
}
