package com.amazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.repository.UserDetailsTableRepository;

@Service
public class UserDetailsTableService {

	@Autowired
	UserDetailsTableRepository userDetailsTableRepository;

	public List<UserDetailsDTO> getAllUserDetails() throws Exception {

		return userDetailsTableRepository.getAllUserDetails();

	}

}
