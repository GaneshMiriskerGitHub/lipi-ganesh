package com.amazon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	UserDetailsRepository UserDetailsRepository;

	@Autowired
	UserDetailsRepository userDetailsRepositoryCRUD;

	public UserDetailsDTO getUserDetailsForThisId(Integer id) throws Exception {
		Optional<UserDetails> optional = userDetailsRepositoryCRUD.findById(id);
		UserDetails userdetails = optional.orElseThrow(() -> new Exception("UserDetails does not exist"));
		UserDetailsDTO userdetailsdto = new UserDetailsDTO();
		userdetailsdto.setAdharcardno(userdetails.getAdharcardno());
		userdetailsdto.setEmail(userdetails.getEmail());
		userdetailsdto.setHealthInsurancePlan(userdetails.getHealthInsurancePlan());
		userdetailsdto.setId(userdetails.getId());
		userdetailsdto.setUsername(userdetails.getUsername());
		return userdetailsdto;
	}

	public List<UserDetailsDTO> getAllUserDetails() {
		Iterable<UserDetails> userdetailsList = userDetailsRepositoryCRUD.findAll();
		
		List<UserDetailsDTO> listdto = new ArrayList<>();
		
		for(UserDetails userdetails : userdetailsList) {
			UserDetailsDTO userdetailsdto = new UserDetailsDTO();
			userdetailsdto.setAdharcardno(userdetails.getAdharcardno());
			userdetailsdto.setEmail(userdetails.getEmail());
			userdetailsdto.setHealthInsurancePlan(userdetails.getHealthInsurancePlan());
			userdetailsdto.setId(userdetails.getId());
			userdetailsdto.setUsername(userdetails.getUsername());
			listdto.add(userdetailsdto);
		}
		
		return listdto;
	}

	public String addUserDetails(UserDetailsDTO userdetailsdto) throws Exception {
		System.out.println("***********" + userdetailsdto.getId());
		UserDetails userdetails = new UserDetails();
		userdetails.setAdharcardno(userdetailsdto.getAdharcardno());
		userdetails.setEmail(userdetailsdto.getEmail());
		userdetails.setHealthInsurancePlan(userdetailsdto.getHealthInsurancePlan());
		userdetails.setId(userdetailsdto.getId());
		userdetails.setUsername(userdetailsdto.getUsername());
		userDetailsRepositoryCRUD.save(userdetails);
		return "success";
	}

	public String deleteUserDetails(Integer id) {
		userDetailsRepositoryCRUD.deleteById(id);
		return "record has been deleted in DataBase successfully";
	}

	public String updateUserDetails(Integer id, String email) throws Exception {
		Optional<UserDetails> optional = userDetailsRepositoryCRUD.findById(id);
		UserDetails userdetails = optional.orElseThrow(() -> new Exception("Service.CUSTOMER_NOT_FOUND"));
		userdetails.setEmail(email);
		return "record has been update in DataBase successfully";
	}

}
