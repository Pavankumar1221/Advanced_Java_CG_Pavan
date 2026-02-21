package com.lpu.CRM_Sales_Management_System;
import javax.persistence.*;
import java.util.*;

@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
	String name;
	String email;
	String phone;
	
	@OneToOne(cascade=CascadeType.ALL)
	Address address;
	
	@OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
	
	public Customer() {}

    public Customer(String name,String email,String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId(){
    	return id; 
    }

    public void setAddress(Address address) {
        this.address = address;
    }
	
}
