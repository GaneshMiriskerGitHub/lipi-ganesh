package com.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.repository.HomeRepository;

@Service
public class HomeService {
	
	@Autowired
	HomeRepository homerepository;

	public String verifyCreds(String username, String password) throws Exception {
		String ui_nunchi_vachina_password = password;
		
		String DB_lo_unna_password = homerepository.getPasswordFor(username);
		
		if(ui_nunchi_vachina_password == DB_lo_unna_password || ui_nunchi_vachina_password.equals(DB_lo_unna_password)) {
			return "SUCCESS";
		}else {
			return "ERROR";
		}
	}

}
