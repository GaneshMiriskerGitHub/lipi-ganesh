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

	public UserDetailsDTO getUserDetailsForThisId(Integer id) {
		return UserDetailsRepository.getUserDetailsForThisId(id);
	}
	
	public List<UserDetailsDTO> getAllUserDetails() {
		return UserDetailsRepository.getAllUserDetails();
	}
	

	public String addUserDetails(UserDetailsDTO userdetailsdto) {
		System.out.println("***********"+userdetailsdto.getId());
		return UserDetailsRepository.addUserDetails(userdetailsdto);
	}
	
	public String deleteCustomer(Integer id) {
		return UserDetailsRepository.deleteCustomer(id);
	}
	
	public String updateCustomer(Integer id, String email) {
		return UserDetailsRepository.updateCustomer(id, email);
	}

}
