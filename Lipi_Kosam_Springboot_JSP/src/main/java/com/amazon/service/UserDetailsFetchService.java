package com.amazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.repository.UserDetailsFetchRepository;

@Service
public class UserDetailsFetchService {
	
	@Autowired
	UserDetailsFetchRepository userDetailsFetchRepository;
	
	public List<UserDetailsDTO> fetchUserDetails(Integer userid) throws Exception {
		return userDetailsFetchRepository.fetchUserDetails(userid);
	}

}
