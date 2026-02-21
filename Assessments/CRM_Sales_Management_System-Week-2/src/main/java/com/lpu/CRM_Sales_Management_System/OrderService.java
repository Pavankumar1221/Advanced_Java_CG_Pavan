package com.lpu.CRM_Sales_Management_System;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.*;

public class OrderService {

    private SessionFactory factory;
    public OrderService(SessionFactory factory) {
        this.factory = factory;
    }

    public void addProduct(String name,double price){

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product p = new Product(name,price);
        session.save(p);

        tx.commit();
        session.close();
    }

    public void placeOrder(Long customerId,List<Long> productIds){

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Customer c = session.get(Customer.class,customerId);

        Order order = new Order();
        order.setCustomer(c);

        for(Long id : productIds){
            Product p = session.get(Product.class,id);
            if(p != null){
                order.addProduct(p);
            }
        }

        session.save(order);

        tx.commit();
        session.close();
    }

    public void raiseTicket(Long orderId,String issue){

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Order o = session.get(Order.class,orderId);

        if(o != null){
            SupportTicket t = new SupportTicket(issue,o);
            session.save(t);
        }

        tx.commit();
        session.close();
    }
}