package in.cg.service;

import java.util.List;

import in.cg.dto.CarRentalDTO;
import in.cg.entity.CarRental;

public interface CarRentalService {

    List<CarRentalDTO> getRentalCarDetails();

    String bookingDetails();

    CarRental addCar(CarRental car);

}