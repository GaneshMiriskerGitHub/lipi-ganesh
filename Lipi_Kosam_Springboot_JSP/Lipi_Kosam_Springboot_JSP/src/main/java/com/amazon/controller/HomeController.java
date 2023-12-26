package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.service.HomeService;
import com.amazon.service.UserDetailsTableService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeservice;

	@Autowired
	UserDetailsTableService userDetailsTableService;

	@GetMapping("/")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/welcome")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) throws Exception {

		System.out.println("Username: " + username);
		System.out.println("Password: " + password);

		String result = homeservice.verifyCreds(username, password);

		String message = "";
		if (result == "SUCCESS") {
			message = "yeyyi... inkem le login ayipoyav, jai bujjammaa";
		} else {
			message = "idendayya idi password marchipoyitivaaa ";
		}

		model.addAttribute("message", message);

		return "welcome";
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello, Spring Boot with JSP!");
		return "hello"; // This refers to the "hello.jsp" view
	}

	@PostMapping("/openForm")
	public String getForm() {
		return "form";
	}

	@GetMapping("/openForm")
	public String getFormabcd() {
		return "form";
	}

	@PostMapping("/submit")
	public String processForm(@RequestParam("inputData") String inputData, Model model) {
		// Process the inputData or perform any other logic here
		// For demonstration purposes, we'll just return the input data to the JSP view.
		model.addAttribute("inputData", inputData);
		return "result";
	}

	@GetMapping("/getAllUserDetailTable")
	public String getAllUserDetails(Model model) throws Exception {
		
		List<UserDetailsDTO> userdetailsData = userDetailsTableService.getAllUserDetails();

		model.addAttribute("userdetailsData", userdetailsData);

		return "userDetailsViewer";
	}

}
