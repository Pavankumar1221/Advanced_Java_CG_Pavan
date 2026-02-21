package com.lpu.CRM_Sales_Management_System;

import javax.persistence.*;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String street;
	String city;
	String state;
	String pincode;
	
	public Address(){
		
	}
	
	public Address(String street, String city, String state, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	
	
}
