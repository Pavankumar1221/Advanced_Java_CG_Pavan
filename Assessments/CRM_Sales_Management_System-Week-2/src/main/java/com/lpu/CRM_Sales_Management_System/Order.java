package com.lpu.CRM_Sales_Management_System;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long Id;
	double totAmount;
	
	@ManyToOne
	Customer customer;
	
	@ManyToMany
	List<Product> prod_list=new ArrayList<>();
	
	public void setCustomer(Customer customer) {
		this.customer=customer;
	}
	
	public void addProduct(Product p) {
		prod_list.add(p);
		totAmount+=p.getPrice();
	}
}
