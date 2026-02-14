package com.lpu.hotel_management;


import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookingService service = new BookingService();

        while (true) {

            System.out.println("--------- HOTEL BOOKING SYSTEM -----------");
            System.out.println("1.Add Booking");
            System.out.println("2.View All Bookings");
            System.out.println("3.Update Booking");
            System.out.println("4.Delete Booking");
            System.out.println("5.Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Room Type (Standard/Deluxe/Suite): ");
                    String room = sc.nextLine();
                    System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
                    String in = sc.nextLine();
                    System.out.print("Enter Check-out Date (YYYY-MM-DD): ");
                    String out = sc.nextLine();

                    Booking b = new Booking(name, room, in, out);
                    service.createReservation(b);
                    break;

                case 2:
                    List<Booking> list = service.fetchReservations();
                    for (Booking bk : list) {
                        System.out.println(
                                bk.getBookingId() + " " +
                                bk.getCustomerName() + " " +
                                bk.getRoomType() + " " +
                                bk.getTotalAmount()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter Booking ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Room Type: ");
                    String newRoom = sc.nextLine();

                    service.modifyRoomType(id, newRoom);
                    System.out.println("Updated Successfully!");
                    break;

                case 4:
                    System.out.print("Enter Booking ID to delete: ");
                    int delId = sc.nextInt();

                    service.cancelReservation(delId);
                    System.out.println("Deleted Successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}