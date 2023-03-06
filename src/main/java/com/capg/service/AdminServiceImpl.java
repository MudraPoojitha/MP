package com.capg.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.entity.Admin;
import com.capg.entity.Booking;
import com.capg.entity.User;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.AdminRepository;
import com.capg.repository.BookingRepository;
import com.capg.repository.BookingdetailsRepository;
import com.capg.repository.UserRepository;



@Service("AdminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public String addAdmin(Admin admin) {
		adminRepository.saveAndFlush(admin);
		return "Admin added successfully";
	}
	
	
	@Override
	public String loginAdmin(String emailId, String password) throws UserNotFoundException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getPassword().equals(password)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		return "Logged in successfully";
	}

	@Override
	public Admin getAdminByEmailId(String aemailId) throws UserNotFoundException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getEmailId().equals(aemailId) ) {
					bean =  i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		return bean;
	}

	@Override
	public Admin updateAdmin(Admin adminDetails) throws UserNotFoundException {
		Admin  bean = null;
		try {
			bean = adminRepository.findById(adminDetails.getaId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		adminRepository.saveAndFlush(adminDetails);
		return bean;
	}
	@Override
    public String isAdmin(String emailId) {
    	Admin bean = new Admin();
        try {
            for(Admin i : adminRepository.findAll()) {
                if(i.getRole().equals("Admin")) {
                	bean = i;
                }
            }
        }
        catch(Exception e) {
            throw new UserNotFoundException("Details not found!");
        }
        return "It is a Admin emailId";
    }

	@Override
	public Admin deleteAdmin(int adminId) throws UserNotFoundException {
		Admin  bean = null;
		try {
			bean = adminRepository.findById(adminId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		adminRepository.deleteById(adminId);
		return bean;
	}

	@Override
	public Admin findByAdminName(String adminName) throws UserNotFoundException {
		Admin bean = new Admin();
		try {
			for(Admin i : adminRepository.findAll()) {
				if(i.getAdminName().equals(adminName) ) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("Admin details not found!");
		}
		return bean;
	}
	@Override
	public String approveBooking(int bookingId) throws UserNotFoundException {
		Booking  bean = new Booking();
		try {
			bean = bookingRepository.findById(bookingId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Booking details not found!");
		}
		bean.setBookingStatus("Approved");
		bookingRepository.saveAndFlush(bean);
		return "Booking is approved";
	}


	@Override
	public String rejectBooking(int bookingId) throws UserNotFoundException {
		Booking  bean = null;
		try {
			bean = bookingRepository.findById(bookingId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Booking details not found!");
		}
		bean.setBookingStatus("Rejected");
		bookingRepository.saveAndFlush(bean);
		return "Booking rejected";
	}

	@Override
	public String disallowBooking(int bookingId) throws UserNotFoundException {
		Booking  bean = null;
		try {
			bean = bookingRepository.findById(bookingId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Booking details not found!");
		}
		bean.setBookingStatus("Disallowed");
		bookingRepository.saveAndFlush(bean);
		return "Booking disallowed";
	}

	@Override
	public String approveCancellation(int bookingId) throws UserNotFoundException {
		Booking  bean = null;
		try {
			bean = bookingRepository.findById(bookingId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("Booking details not found!");
		}
		bean.setBookingStatus("Cancelled");
		bookingRepository.saveAndFlush(bean);
		return "Cancellation approved";
	}



}
