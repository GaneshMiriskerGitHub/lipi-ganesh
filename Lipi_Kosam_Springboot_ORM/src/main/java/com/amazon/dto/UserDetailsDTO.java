package com.amazon.dto;

public class UserDetailsDTO {
	
	
	private Integer id; 
	private String username; 
    private String email;
    private String adharcardno;
    private HealthInsurancePlan healthInsurancePlan;
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdharcardno() {
		return adharcardno;
	}
	public void setAdharcardno(String adharcardno) {
		this.adharcardno = adharcardno;
	}
	public HealthInsurancePlan getHealthInsurancePlan() {
		return healthInsurancePlan;
	}
	public void setHealthInsurancePlan(HealthInsurancePlan healthInsurancePlan) {
		this.healthInsurancePlan = healthInsurancePlan;
	}
	
	
    
	

}
