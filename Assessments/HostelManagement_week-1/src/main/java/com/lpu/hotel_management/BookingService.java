package com.lpu.hotel_management;

import org.hibernate.*;

import java.util.*;

public class BookingService {

    public void createReservation(Booking booking) {
        double total = PriceCalculator.generateTotal(
                booking.getRoomType(),
                booking.getCheckInDate(),
                booking.getCheckOutDate()
        );

        booking.setTotalAmount(total);
        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(booking);

        tx.commit();
        session.close();

        System.out.println("Reservation Added Successfully!");
    }

    public List<Booking> fetchReservations() {
        Session session = HibernateUtil.getFactory().openSession();
        List<Booking> list = session.createQuery("from Booking", Booking.class).list();
        session.close();
        return list;
    }

    public void modifyRoomType(int id, String newType) {
    	
        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        Booking b = session.get(Booking.class, id);
        b.setRoomType(newType);

        double total = PriceCalculator.generateTotal(
                newType,
                b.getCheckInDate(),
                b.getCheckOutDate()
        );

        b.setTotalAmount(total);

        tx.commit();
        session.close();
    }

    public void cancelReservation(int id) {
        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Booking b = session.get(Booking.class, id);
        session.delete(b);

        tx.commit();
        session.close();
    }
}