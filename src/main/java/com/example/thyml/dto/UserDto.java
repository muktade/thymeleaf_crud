package com.example.thyml.dto;

import com.example.thyml.entity.User;

public class UserDto {
	
	private Long id;
	private String name;
	private Double basicSalary;
	private Double bonus;
	private Double totalSalary;
	
	
	public UserDto () {
		
	}
	
	public UserDto(User user) {
		id = user.getId();
		name = user.getName();
		totalSalary = basicSalary + bonus;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	public Double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(Double totalSalary) {
		this.totalSalary = totalSalary;
	}
	
}
