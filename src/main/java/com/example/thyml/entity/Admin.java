package com.example.thyml.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Admin extends BaseEntity{
	
	@ManyToOne
	private User user;
	
	private String designation;
	
}
