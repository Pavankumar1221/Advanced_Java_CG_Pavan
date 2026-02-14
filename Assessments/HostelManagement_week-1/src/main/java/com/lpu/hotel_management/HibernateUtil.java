package com.lpu.hotel_management;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionfactory;
    static {
        sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Booking.class)
                .buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return sessionfactory;
    }
}