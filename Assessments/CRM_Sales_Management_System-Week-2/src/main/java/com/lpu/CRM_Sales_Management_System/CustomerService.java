package com.lpu.CRM_Sales_Management_System;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class CustomerService {

    SessionFactory factory;
    public CustomerService(SessionFactory factory) {
        this.factory = factory;
    }

    public void registerCustomer(String name,String email,String phone) {

        Session session = factory.openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Customer c = new Customer(name,email,phone);
            session.save(c);

            
            transaction.commit();
            System.out.println("Customer registered");
        }catch (Exception e) {
            if(transaction != null) {
            	transaction.rollback();
            }
        }finally {
            session.close();
        }
    }

    public void addAddress(Long customerId, Address address) {

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

        Customer customer=session.get(Customer.class, customerId);
        if(customer != null){
            customer.setAddress(address);
            session.update(customer);
        }

        transaction.commit();
        session.close();
    }
}