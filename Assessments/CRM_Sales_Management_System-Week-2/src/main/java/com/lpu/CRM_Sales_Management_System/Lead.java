package com.lpu.CRM_Sales_Management_System;
import javax.persistence.*;
import java.util.*;

@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;

    private String name;
    private String source;
    private String contactInfo;

    @ManyToOne
    private SalesEmployee employee;

    public Lead() {}

    public Lead(String name, String source, String contactInfo) {
        this.name = name;
        this.source = source;
        this.contactInfo = contactInfo;
    }
    
    public void setEmployee(SalesEmployee emp) {
    	this.employee=emp;
    }
}