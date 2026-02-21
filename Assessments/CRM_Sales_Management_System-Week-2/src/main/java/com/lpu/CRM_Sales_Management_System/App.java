package com.lpu.CRM_Sales_Management_System;

import java.util.*;

import org.hibernate.SessionFactory;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SessionFactory factory = HibernateUtil.getFactory();
        CustomerService customerService = new CustomerService(factory);

        LeadService leadService=new LeadService(factory);

        OrderService orderService=new OrderService(factory);

        while (true) {

            System.out.println("\n******* CRM MENU *******");
            System.out.println("1.Register Customer");
            System.out.println("2.Add Address To Customer");
            System.out.println("3.Create Lead");
            System.out.println("4.Add Product");
            System.out.println("5.Place Order");
            System.out.println("6.Raise Support Ticket");
            System.out.println("7.Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter email: ");
                    String email = sc.next();
                    System.out.print("Enter phone: ");
                    String phone = sc.next();
                    customerService.registerCustomer(name,email,phone);
                    break;

                case 2:

                    System.out.print("Enter Customer ID: ");
                    Long cid = sc.nextLong();

                    sc.nextLine(); 

                    System.out.print("Enter Street: ");
                    String street = sc.nextLine();

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();

                    System.out.print("Enter State: ");
                    String state = sc.nextLine();

                    System.out.print("Enter Zip Code: ");
                    String zip = sc.nextLine();

                    Address addr = new Address(street, city, state, zip);

                    customerService.addAddress(cid, addr);
                    break;

                case 3:
                    System.out.print("Enter Lead Name: ");
                    String lname = sc.next();
                    System.out.print("Enter Source: ");
                    String source = sc.next();
                    System.out.print("Enter Contact Number: ");
                    String contact = sc.next();

                    leadService.createLead(lname,source,contact);
                    break;

                case 4:
                    System.out.print("Enter Product Name: ");
                    String pname = sc.next();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    orderService.addProduct(pname,price);
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    Long custId = sc.nextLong();
                    System.out.print("Enter Product ID: ");
                    Long pid = sc.nextLong();

                    orderService.placeOrder(custId,Arrays.asList(pid));
                    break;

                case 6:
                    System.out.print("Order ID: ");
                    Long oid = sc.nextLong();
                    System.out.print("Issue: ");
                    String issue = sc.next();
                    orderService.raiseTicket(oid,issue);
                    break;

                case 7:
                    HibernateUtil.close();
                    sc.close();
                    System.out.println("Application closed.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
