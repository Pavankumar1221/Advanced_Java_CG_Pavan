package in.cg.service;

import in.cg.dto.PassengerCarResponseDTO;
import in.cg.entity.Passenger;

public interface PassengerService {

    Passenger addPassenger(Passenger passenger);

    PassengerCarResponseDTO getPassengerDetails(Long id);

}