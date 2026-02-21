package com.lpu.CRM_Sales_Management_System;
import javax.persistence.*;
import java.util.*;

@Entity
public class SalesEmployee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String name;
	String department;
	
	@OneToMany(mappedBy = "employee")
    List<Lead> lead = new ArrayList<>();
	
	public SalesEmployee() {
		
	}
    public SalesEmployee(String name,String department) {
        this.name=name;
        this.department=department;
    }
	
}
