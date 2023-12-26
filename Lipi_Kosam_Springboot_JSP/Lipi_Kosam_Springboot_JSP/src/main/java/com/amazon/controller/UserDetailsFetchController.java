package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.service.UserDetailsFetchService;

@RestController
public class UserDetailsFetchController {
	
	@Autowired
	UserDetailsFetchService userDetailsFetchSerivce;
	
	@PostMapping("/fetchUserByUserId")
	public List<UserDetailsDTO> fetchUserDetails(@RequestParam("userid") Integer userid, Model model) throws Exception {
		System.out.println("********* " + userid);
		
		List<UserDetailsDTO> userdetailsData = userDetailsFetchSerivce.fetchUserDetails(userid);
		
		model.addAttribute("userdetailsData", userdetailsData);
		
		return userdetailsData;
	}

}
