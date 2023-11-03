package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.service.UserDetailsService;

@RestController
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/getUserDetails/{id}")
	public UserDetailsDTO getUserDetailsForThisId(@PathVariable("id") Integer id) {
	
		UserDetailsDTO dtoObj = userDetailsService.getUserDetailsForThisId(id);
		
		return dtoObj;
		
	}
	
	@GetMapping("/getAllUserDetails")
	public List<UserDetailsDTO> getAllUserDetails() {
		return userDetailsService.getAllUserDetails();
	}

}
