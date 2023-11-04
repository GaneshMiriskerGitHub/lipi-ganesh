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
public class UserDetailsRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public UserDetailsDTO getUserDetailsForThisId(Integer id) {

		UserDetailsDTO dtoObj = new UserDetailsDTO();

		UserDetails obj = entityManager.find(UserDetails.class,id );
				
				//entityManager.find(UserDetails.class, id);
		
		dtoObj.setId(obj.getId());
		dtoObj.setAdharcardno(obj.getAdharcardno());
		dtoObj.setEmail(obj.getEmail());
		dtoObj.setHealthInsurancePlan(obj.getHealthInsurancePlan());
		dtoObj.setUsername(obj.getUsername());

		return dtoObj;

	}
	

	
	public List<UserDetailsDTO> getAllUserDetails() {
	    List<UserDetailsDTO> userDetailsList = new ArrayList<>();
	    
	    // Use a query to retrieve all records from the UserDetails table
	    String query = "SELECT u FROM UserDetails u";
	    TypedQuery<UserDetails> userDetailsEntityList = entityManager.createQuery(query, UserDetails.class);
	    List<UserDetails> userDetailsEntities = userDetailsEntityList.getResultList();

	    for (UserDetails userDetails : userDetailsEntities) {
	        UserDetailsDTO dtoObj = new UserDetailsDTO();
	        dtoObj.setId(userDetails.getId());
	        dtoObj.setAdharcardno(userDetails.getAdharcardno());
	        dtoObj.setEmail(userDetails.getEmail());
	        dtoObj.setHealthInsurancePlan(userDetails.getHealthInsurancePlan());
	        dtoObj.setUsername(userDetails.getUsername());
	        userDetailsList.add(dtoObj);
	    }

	    return userDetailsList;
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
	
	public String deleteCustomer(Integer id) {
		UserDetails userdetails = entityManager.find(UserDetails.class, id);
		entityManager.remove(userdetails);
		return "success: record is deleted";
	}
	
	
	public String updateCustomer(Integer id, String email) {
		UserDetails userdetails = entityManager.find(UserDetails.class, id);
		userdetails.setEmail(email);
		return "success: email is updated";
	}
}
