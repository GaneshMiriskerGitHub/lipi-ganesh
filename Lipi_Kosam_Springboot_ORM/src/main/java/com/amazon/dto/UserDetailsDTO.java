package com.amazon.dto;

import jakarta.validation.constraints.Max;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/*
 {
    "id":"4",
    "username":"abcd",
    "email":"abcd@abcd.com",
    "adharcardno":"23673635473",
    "healthInsurancePlan":"GOLD"

}
 */

@Getter
@Setter
public class UserDetailsDTO {

	@Min(value=0, message="id must not be negative")
	@Max(value=15, message="id must not exceed 15")
	private Integer id; 
	private String username; 
	@NotBlank(message="email must not be empty")
    private String email;
    private String adharcardno;
    private HealthInsurancePlan healthInsurancePlan;
    
    
    
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getAdharcardno() {
//		return adharcardno;
//	}
//	public void setAdharcardno(String adharcardno) {
//		this.adharcardno = adharcardno;
//	}
//	public HealthInsurancePlan getHealthInsurancePlan() {
//		return healthInsurancePlan;
//	}
//	public void setHealthInsurancePlan(HealthInsurancePlan healthInsurancePlan) {
//		this.healthInsurancePlan = healthInsurancePlan;
//	}
//	
	
    
	

}
