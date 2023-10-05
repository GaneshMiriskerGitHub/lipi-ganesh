package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.service.CRUDTableService;
import com.amazon.service.UserDetailsTableService;

@Controller
public class CRUDTableController {

	@Autowired
	UserDetailsTableService userDetailsTableService;

	@Autowired
	CRUDTableService cRUDTableService;

	@GetMapping("/openCrudTableScreen")
	public String openCRUDTableScreen(Model model) throws Exception {

		List<UserDetailsDTO> userdetailsData = userDetailsTableService.getAllUserDetails();

		model.addAttribute("userdetailsData", userdetailsData);

		return "crudTable";
	}

	@PostMapping("/openCrudTableScreen/updateUser")
	public String editUserDetails(@RequestParam("username") String username,
			@RequestParam("adharcardno") String adharcardno, @RequestParam("email") String email,
			@RequestParam("userid") String userid, Model model) throws Exception {

		System.out.println("user id vachindi = " + userid);
		System.out.println("user name vachindi = " + username);
		System.out.println("adhar card number vachindi = " + adharcardno);
		System.out.println("email  vachindi = " + email);

		String message = cRUDTableService.updateUserDetails(userid, username, adharcardno, email);
		System.out.println("message = " + message);
		return "redirect:/openCrudTableScreen";
	}

	@GetMapping("/openCrudTableScreen/deleteUser/{userid}")
	public String deleteUserDetails(@PathVariable String userid, Model model) throws Exception {
		System.out.println("*********** user id = " + userid);
		String message = cRUDTableService.deleteUserDetails(userid);
		return "redirect:/openCrudTableScreen";
	}

	@PostMapping("openCrudTableScreen/addUser")
	public String addNewUserDetails(@RequestParam("username") String username,
			@RequestParam("adharcardno") String adharcardno, @RequestParam("email") String email, Model model)
			throws Exception {

		System.out.println("user name vachindi = " + username);
		System.out.println("adhar card number vachindi = " + adharcardno);
		System.out.println("email  vachindi = " + email);

		String message = cRUDTableService.addNewUserDetails(username, adharcardno, email);

		return "redirect:/openCrudTableScreen";
	}

}
