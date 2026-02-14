package com.lpu.hotel_management;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PriceCalculator {

    public static double getRoomPrice(String roomType) {
        switch (roomType.toLowerCase()) {
            case "standard": 
            	return 2000;
            case "deluxe": 
            	return 3500;
            case "suite": 
            	return 5000;
            default: 
            	throw new IllegalArgumentException("Invalid Room Type");
        }
    }

    public static long countDays(String in, String out) {
    	
        LocalDate checkIn = LocalDate.parse(in);
        LocalDate checkOut = LocalDate.parse(out);
        return ChronoUnit.DAYS.between(checkIn, checkOut);
        
    }

    public static double generateTotal(String roomType, String in, String out) {
        long days = countDays(in, out);
        double price = getRoomPrice(roomType);
        double total = days * price;
        if (days > 5) {
            total = total * 0.9;
        }
        return total;
    }
}
