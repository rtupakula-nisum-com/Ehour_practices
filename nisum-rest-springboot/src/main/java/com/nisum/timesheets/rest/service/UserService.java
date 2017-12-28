package com.nisum.timesheets.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.timesheets.rest.domain.User;
import com.nisum.timesheets.rest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String userName) {
		return userRepository.findByUsername(userName);
		
	}

}
