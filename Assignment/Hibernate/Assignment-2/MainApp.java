package com.lpu.TestMaven.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        

//        Session s = HibernateUtil.getSessionFactory().openSession();
//        Transaction tr = s.beginTransaction();
        
        SessionFactory sf=null;
        Session session=null;
        Transaction tr=null;
        
        try {
        	System.out.println("Starting Hibernate...");
        	
        	Configuration cfg=new Configuration();
        	cfg.configure("hibernate.cfg.xml");
        	
        	sf=cfg.buildSessionFactory();
        	
        	session=sf.openSession();
        	
        	tr=session.beginTransaction();
        	
        	
//        	create
//        	User user = new User();
//        	user.setId(4);
//        	user.setName("Cbum");
//        	user.setEmail("cbum@gmail.com");
//        	user.setPhoneno(9876543210L);
//        	user.setCity("Canada");
//        	
//          session.save(user);
//            
//          System.out.println("Data inserted Sucessfuly");
        	
        	
//        	read one
//        	User user = session.get(User.class, 3L);
//            if (user != null) {
//                System.out.println(user.getName());
//                System.out.println(user.getEmail());
//            }
        	
        	
        	
//        	read all
//        	List<User> users = session.createQuery("from User", User.class).list();
//
//            for (User u : users) {
//                System.out.println(
//                        u.getId() + " | " +
//                        u.getName() + " | " +
//                        u.getEmail() + " | " +
//                        u.getCity() + " | " +
//                        u.getPhoneno()
//                );
//            }
        	
//        	update
//        	 User user = session.get(User.class, 3L);
//             if (user != null) {
//                 user.setCity("Chennai");
//             }
        	
        	
//        	delete
//        	User user = session.get(User.class, 2L);
//            if (user != null) {
//                session.delete(user);
//            }
        	
            
            
            
            tr.commit();
            System.out.println("Operation sucessfull");
        	
        	
        }catch(Exception e) {
        	System.out.println("Error Ocurred!");
        	e.printStackTrace();
        	
        	if(tr!=null) tr.rollback();
        	
        } finally {

            if (session != null) session.close();
            if (sf != null) sf.close();
        }
        
        
        
        
        
        	
        
//        configuration is used to read the hibernate.cfg.xml file
//        Configuration cfg=new Configuration();
//      load xml configuration
//        cfg.configure("hibernate.cfg.xml");
        
//        session factory is used to create session obejcts  
//        SessionFactory sf=cfg.buildSessionFactory();
        
//        session is used to perform db operations crud
//        Session s=sf.openSession();
//        ensure transactions are safe
//        Transaction tr=s.beginTransaction();
        

//        User user = new User();
//        user.setId(2);
//        user.setName("Pavan");
//        user.setEmail("pavan@gmail.com");
//        user.setPhoneno(9876543210L);
//        user.setCity("Hyderabad");

//        user.setId(3);
//        user.setName("Raj");
//        user.setEmail("Raj@gmail.com");
//        user.setPhoneno(9876543210L);
//        user.setCity("banglore");
        
        
//        create operation insert the data inside the table
//        s.save(user);
        
       

//        System.out.println("Data inserted successfully!");
    }
}
