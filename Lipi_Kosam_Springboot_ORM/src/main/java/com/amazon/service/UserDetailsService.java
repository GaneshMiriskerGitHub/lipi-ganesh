package com.amazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.entity.UserDetails;
import com.amazon.repository.UserDetailsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsService {
	
	@Autowired
	UserDetailsRepository  UserDetailsRepository;

	public UserDetails getUserDetailsForThisId(Integer id) {
		return UserDetailsRepository.getUserDetailsForThisId(id);
	}
	
//	public List<UserDetailsDTO> getAllUserDetails() {
//		return UserDetailsRepository.getAllUserDetails();
//	}
	

	public String addUserDetails(UserDetailsDTO userdetailsdto) {
		System.out.println("***********"+userdetailsdto.getId());
		return UserDetailsRepository.addUserDetails(userdetailsdto);
	}
	
	public String deleteUserDetails(Integer id) {
		return UserDetailsRepository.deleteUserDetails(id);
	}
	
	public String updateUserDetails(Integer id, String email) {
		return UserDetailsRepository.updateUserDetails(id, email);
	}

}
