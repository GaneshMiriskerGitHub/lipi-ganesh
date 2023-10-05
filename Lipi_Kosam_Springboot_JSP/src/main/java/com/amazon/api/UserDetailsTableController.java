package com.amazon.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.service.UserDetailsTableService;

@RestController
public class UserDetailsTableController {
	
	@Autowired
	UserDetailsTableService userDetailsTableService;
	
	@GetMapping("/getUserDetailsAPI")
	public List<UserDetailsDTO> getAllUserDetails() throws Exception {
		return userDetailsTableService.getAllUserDetails();
	}

	

}
