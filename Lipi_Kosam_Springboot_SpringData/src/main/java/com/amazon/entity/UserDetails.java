package com.amazon.entity;

import com.amazon.dto.HealthInsurancePlan;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userdetails")
public class UserDetails {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
    private String email;
	
    @Column(name="adhar_card_no")
    private String adharcardno;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="health_insurance_plan")
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
