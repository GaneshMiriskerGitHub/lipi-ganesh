package com.amazon.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.amazon.service.DropDownService;


@Controller
public class DropDownController {
	
	@Autowired
	DropDownService dropDownService;

	@GetMapping("/dropdownData")
	public String showDropdown(Model model) throws Exception {
		List<String> data = dropDownService.getCustCodeList();
		model.addAttribute("dropdownData", data);
		return "dropdown";
	}

}
