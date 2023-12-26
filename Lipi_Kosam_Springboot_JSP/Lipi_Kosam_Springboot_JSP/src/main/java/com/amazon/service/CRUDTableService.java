package com.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.repository.CRUDTableRepository;

@Service
public class CRUDTableService {
	
	@Autowired
	CRUDTableRepository cRUDTableRepository;
	
	public String deleteUserDetails(String userid) throws Exception{
		return cRUDTableRepository.deleteUserDetails(userid);
	}
	
	public String updateUserDetails(String userid, String username, String adharno, String email) throws Exception{
		return cRUDTableRepository.updateUserDetails(userid, username, adharno, email);
	}
	
	public String addNewUserDetails(String username, String adharno, String email) throws Exception{
		return cRUDTableRepository.addNewUserDetails(username, adharno, email);
	}

}
