package com.amazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.repository.UserDetailsRepository;

@Service
public class UserDetailsService {
	
	@Autowired
	UserDetailsRepository  UserDetailsRepository;

	public UserDetailsDTO getUserDetailsForThisId(Integer id) {
		return UserDetailsRepository.getUserDetailsForThisId(id);
	}
	
	public List<UserDetailsDTO> getAllUserDetails() {
		return UserDetailsRepository.getAllUserDetails();
	}

}
