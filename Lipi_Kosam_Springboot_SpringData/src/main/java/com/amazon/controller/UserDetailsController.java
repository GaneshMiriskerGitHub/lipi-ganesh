package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.service.UserDetailsService;

import jakarta.validation.Valid;

@RestController
public class UserDetailsController {

	@Autowired
	UserDetailsService userDetailsService;

	@GetMapping("/getUserDetails/{id}")
	public ResponseEntity<?> getUserDetailsForThisId(@PathVariable("id") Integer id) throws Exception {

		UserDetailsDTO dtoObj = userDetailsService.getUserDetailsForThisId(id);

		return new ResponseEntity<>(dtoObj, HttpStatus.OK);
	}

	@GetMapping("/getAllUserDetails")
	public ResponseEntity<?> getAllUserDetails() throws Exception {
		List<UserDetailsDTO> listDTO = userDetailsService.getAllUserDetails();
		return new ResponseEntity<>(listDTO, HttpStatus.OK);
	}

	@PostMapping("/addUserDetails")
	public ResponseEntity<?> addUserDetails(@RequestBody @Valid  UserDetailsDTO userdetailsdto) throws Exception {
		System.out.println(userdetailsdto.getId() + " ********************");
		
		String msg = userDetailsService.addUserDetails(userdetailsdto);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@PostMapping("deleteUserDetails/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id) {

		return new ResponseEntity<>(userDetailsService.deleteUserDetails(id), HttpStatus.OK);
	}

	@PostMapping("/updateEmail")
	public ResponseEntity<String> updateCustomer(@RequestParam("id") Integer id, @RequestParam("email") String email) throws Exception {
		String msg = userDetailsService.updateUserDetails(id, email);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

}
