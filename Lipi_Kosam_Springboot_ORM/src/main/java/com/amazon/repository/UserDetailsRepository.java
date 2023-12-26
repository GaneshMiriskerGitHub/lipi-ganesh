package com.amazon.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazon.dto.UserDetailsDTO;
import com.amazon.entity.UserDetails;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
public class UserDetailsRepository  {
	
	@PersistenceContext
	EntityManager entityManager;
	

	public UserDetails getUserDetailsForThisId(Integer id) {


		UserDetails obj = entityManager.find(UserDetails.class,id );
				
		

		return obj;

	}
	

	
	public List<UserDetails> getAllUserDetails() {
	  
	    
	    // Use a query to retrieve all records from the UserDetails table
	    String query = "SELECT u FROM UserDetails u";
	    TypedQuery<UserDetails> userDetailsEntityList = entityManager.createQuery(query, UserDetails.class);
	    List<UserDetails> userDetailsEntities = userDetailsEntityList.getResultList();

	    
	    
	    

	    return userDetailsEntities;
	}

	
	public String addUserDetails(UserDetailsDTO userdetailsdto) {
		
		// Dto motham Entity lo set cheyyali
		UserDetails userDetails = new UserDetails();
		userDetails.setAdharcardno(userdetailsdto.getAdharcardno());
		userDetails.setEmail(userdetailsdto.getEmail());
		userDetails.setHealthInsurancePlan(userdetailsdto.getHealthInsurancePlan());
		userDetails.setId(userdetailsdto.getId());
		userDetails.setUsername(userdetailsdto.getUsername());
		
		entityManager.persist(userDetails);
		return "success";
	}
	
	
	public String deleteUserDetails(Integer id) {
		UserDetails userdetails = entityManager.find(UserDetails.class, id);
		entityManager.remove(userdetails);
		return "success: record is deleted";
	}
	
	
	public String updateUserDetails(Integer id, String email) {
		UserDetails userdetails = entityManager.find(UserDetails.class, id);
		userdetails.setEmail(email);
		return "success: email is updated";
	}
	
	
}
