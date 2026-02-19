package com.lpu.TestMaven.Mapping_one_to_one;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainApp {
    public static void main(String[] args) {

        Session session = new Configuration()
                .configure()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Aadhar.class)
                .buildSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        // Create Aadhar
        Aadhar a = new Aadhar();
        a.setAadharNumber("1234-5678-9999");

        // Create Person
        Person p = new Person();
        p.setName("Pavan");
        p.setCity("Punjab");
        p.setAadhar(a);   // linking

        session.save(p);

        tx.commit();
        session.close();

        System.out.println("Data saved successfully");
    }
}
