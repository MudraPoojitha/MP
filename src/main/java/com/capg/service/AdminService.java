package com.capg.service;

import com.capg.entity.Admin;
import com.capg.exception.UserNotFoundException;


public interface AdminService {

	public String addAdmin(Admin admin);
	public String loginAdmin(String emailId,String password)throws UserNotFoundException;
	public Admin getAdminByEmailId(String aemailId)throws UserNotFoundException;
	public Admin updateAdmin(Admin adminDetails)throws UserNotFoundException;
	public String isAdmin(String emailId);
	public Admin deleteAdmin(int adminId) throws UserNotFoundException;
	public Admin findByAdminName(String adminName) throws UserNotFoundException;
	public String approveBooking(int bookingId)throws UserNotFoundException;
	public String rejectBooking(int bookingId)throws UserNotFoundException;
	public String disallowBooking(int bookingId)throws UserNotFoundException;
	public String approveCancellation(int bookingId)throws UserNotFoundException;


}
