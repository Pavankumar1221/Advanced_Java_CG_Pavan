package com.lpu.Mapping_Hiberntae;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        // STEP 1: Load configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        // STEP 2: Create SessionFactory (Heavy object - created once)
        SessionFactory factory = cfg.buildSessionFactory();

        // STEP 3: Open Session (connection with DB)
        Session session = factory.openSession();

        // STEP 4: Start transaction
        Transaction tx = session.beginTransaction();


        // STEP 5: Create Objects
        Course c1 = new Course();
        c1.setName("Java");

        Course c2 = new Course();
        c2.setName("Hibernate");

        Student s1 = new Student();
        s1.setName("Pavan");

        // CONNECTING Student with Courses
        s1.getCourses().add(c1);
        s1.getCourses().add(c2);


        // Save student 
        session.save(s1);

        // STEP 6: Commit transaction
        tx.commit();

        // STEP 7: Close resources
        session.close();
        factory.close();

        System.out.println("Data Saved Successfully!");
    }
}
