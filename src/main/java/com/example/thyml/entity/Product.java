package com.example.thyml.entity;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product extends BaseEntity{

	private String brand;
	private Double quantity;
	private Double price;
	private String photoPath;

	@Transient
	private MultipartFile photo;
	
}
