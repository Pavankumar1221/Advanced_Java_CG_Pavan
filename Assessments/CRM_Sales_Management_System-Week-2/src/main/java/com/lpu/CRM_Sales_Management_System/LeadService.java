package com.lpu.CRM_Sales_Management_System;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LeadService {

    private SessionFactory factory;
    public LeadService(SessionFactory factory) {
        this.factory = factory;
    }

    public void createLead(String name,String source,String contact){
//    	opening the session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

//      providing the values to the Lead class
        Lead l = new Lead(name,source,contact);
        session.save(l);

        tx.commit();
        session.close();

        System.out.println("Lead created");
    }

    public void assignLead(Long leadId, Long empId){

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Lead lead = session.get(Lead.class,leadId);
        SalesEmployee emp = session.get(SalesEmployee.class,empId);

        if(lead != null && emp != null){
            lead.setEmployee(emp);
            session.update(lead);
        }

        tx.commit();
        session.close();
    }
}