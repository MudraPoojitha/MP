package com.capg.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.entity.User;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.BookingRepository;
import com.capg.repository.UserRepository;


@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public String addUser(User user) {
		userRepository.saveAndFlush(user);
		return "User added successfully";
	}
	

	@Override
	public String loginUser(String emailId, String password) throws UserNotFoundException {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getPassword().equals(password)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return "Logged in successfully";
	}

	@Override
	public User findByUserEmailId(String emailId) throws UserNotFoundException {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return bean;
	}


	@Override
	public boolean validateSecurityAnswer(String emailId, String securityAnswer) {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getSecurityAnswer().equals(securityAnswer)) {
					return true;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return false;
	}

	@Override
	public String resetPassword(String emailId, String password) {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) ) {
					i.setPassword(password);
					userRepository.saveAndFlush(i);
					return "updated password";
					
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return "User details not found!";
		
	}

	@Override
	public String deleteUserByEmailId(String emailId, String password) {
		User bean = new User();
		try {
			for(User i : userRepository.findAll()) {
				if(i.getEmailId().equals(emailId) && i.getPassword().equals(password)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		userRepository.deleteById(bean.getuId());
		return "User deleted successfully";
 }


}




