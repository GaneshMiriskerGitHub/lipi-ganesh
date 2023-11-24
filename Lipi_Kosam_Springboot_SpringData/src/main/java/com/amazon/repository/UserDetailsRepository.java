package com.amazon.repository;

import org.springframework.data.repository.CrudRepository;

import com.amazon.entity.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer>{
	
	

}
