package com.lpu.CRM_Sales_Management_System;
import javax.persistence.*;
import java.util.*;

@Entity
public class SupportTicket {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
	String issueDescription;

    @OneToOne
    Order order;

    public SupportTicket() {
    	
    }
    SupportTicket(String issueDescription, Order order) {
        this.issueDescription = issueDescription;
        this.order = order;
    }
}
