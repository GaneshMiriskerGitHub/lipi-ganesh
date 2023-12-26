package com.amazon.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.dto.UserDetailsDTO;

@RestController
@RequestMapping("/api")
public class HomeAPI {
	
	@GetMapping("/getUserDetails")
    public UserDetailsDTO getUserDetails() {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setUsername("abcd");
        userDetailsDTO.setEmail("abcd@abcd.com");
        return userDetailsDTO;
    }

}
