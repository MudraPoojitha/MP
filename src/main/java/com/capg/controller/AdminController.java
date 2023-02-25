package com.capg.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.LoginRequest;
import com.capg.entity.Admin;
import com.capg.entity.Booking;
import com.capg.entity.Bookingdetails;
import com.capg.entity.Seat;
import com.capg.entity.User;
import com.capg.exception.SeatNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.service.AdminService;
import com.capg.service.BookingService;
import com.capg.service.SeatService;
import com.capg.service.UserService;

@RestController
@RequestMapping("/onlineseat-admins")
public class AdminController {

	@Autowired
	AdminService adminService;

	
	@PostMapping("/addadmin")
	public String addAdmin(@RequestBody Admin admin)
	{
		return adminService.addAdmin(admin);
	}
	
	@PostMapping("/loginAdmin")
	public String loginAdmin(@RequestBody LoginRequest request)throws UserNotFoundException
	{
		
	return adminService.loginAdmin(request.getEmail(), request.getPassword());
	}
	
	
	
	@GetMapping("/getAdminById/{aemailId}")
	public Admin getAdminById(@PathVariable String aemailId) throws UserNotFoundException{
		return adminService.getAdminByEmailId(aemailId);
	}
	
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin)throws UserNotFoundException{
		return adminService.updateAdmin(admin);
	}
	
	
	@DeleteMapping("/deleteAdmin/{id}")
	public Admin deleteAdmin(@PathVariable int id) {
		return adminService.deleteAdmin(id);
	}
	
	@GetMapping("/findByAdminName/{adminName}")
	public Admin findByAdminName(@PathVariable String adminName)
	{
		return adminService.findByAdminName(adminName);
	}
	
	@PutMapping("/grantAdminRights/{emailId}")
    public boolean grantAdminRights(@PathVariable String emailId) {
		return adminService.grantAdminRights(emailId);
    }
	
	@PutMapping("/approveBooking/{bookingId}")
	public Bookingdetails approveBooking(int bookingId)throws UserNotFoundException{
		return adminService.approveBooking(bookingId);
	}
	
	@PutMapping("/rejectBooking/{bookingId}")
	public Bookingdetails rejectBooking(int bookingId)throws UserNotFoundException{
		return adminService.rejectBooking(bookingId);
	}
	
	@PutMapping("/disallowBooking/{bookingId}")
	public Bookingdetails disallowBooking(int bookingId)throws UserNotFoundException{
		return adminService.disallowBooking(bookingId);
	}
	
	@PutMapping("/approveCancellation/{bookingId}")
	public Bookingdetails approveCancellation(int bookingId)throws UserNotFoundException{
		return adminService.approveCancellation(bookingId);
	}
	


}
