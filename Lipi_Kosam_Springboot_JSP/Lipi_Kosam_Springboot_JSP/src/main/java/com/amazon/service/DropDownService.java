package com.amazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.repository.DropDownRepository;

@Service
public class DropDownService {
	
	@Autowired
	DropDownRepository dropDownRepository;
	
	public List<String> getCustCodeList() throws Exception {
		return dropDownRepository.getCustCodeList();
	}

}
