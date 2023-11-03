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
		dtoObj.setHealthInsurance(obj.getHealthInsurancePlan());
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
	        dtoObj.setHealthInsurance(userDetails.getHealthInsurancePlan());
	        dtoObj.setUsername(userDetails.getUsername());
	        userDetailsList.add(dtoObj);
	    }

	    return userDetailsList;
	}

}
