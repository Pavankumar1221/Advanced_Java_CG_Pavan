package com.lpu.CRM_Sales_Management_System;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void close() {
        if (factory != null)
            factory.close();
    }
}