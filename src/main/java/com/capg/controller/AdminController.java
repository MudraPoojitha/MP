package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.LoginRequest;
import com.capg.entity.Admin;
import com.capg.exception.UserNotFoundException;
import com.capg.service.AdminService;

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
	@GetMapping("/isAdmin/{emailId}")
    public String isAdmin(@PathVariable String emailId) {
        return adminService.isAdmin(emailId);
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
	
	@PutMapping("/approveBooking/{bookingId}")
	public String approveBooking(@PathVariable int bookingId)throws UserNotFoundException{
		return adminService.approveBooking(bookingId);
	}
	
	@PutMapping("/rejectBooking/{bookingId}")
	public String rejectBooking(@PathVariable int bookingId)throws UserNotFoundException{
		return adminService.rejectBooking(bookingId);
	}
	
	@PutMapping("/disallowBooking/{bookingId}")
	public String disallowBooking(@PathVariable int bookingId)throws UserNotFoundException{
		return adminService.disallowBooking(bookingId);
	}
	
	@PutMapping("/approveCancellation/{bookingId}")
	public String approveCancellation(@PathVariable int bookingId)throws UserNotFoundException{
		return adminService.approveCancellation(bookingId);
	}

}
