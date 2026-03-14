package in.cg.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import in.cg.dto.CarRentalDTO;
import in.cg.dto.PassengerCarResponseDTO;
import in.cg.entity.Passenger;
import in.cg.feign.CarRentalFeignClient;
import in.cg.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private CarRentalFeignClient carRentalFeignClient;

    // Insert Passenger
    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    // Fetch passenger + car details
    @Override
    @CircuitBreaker(name = "car-rental-service", fallbackMethod = "fallbackGetPassengerDetails")
    public PassengerCarResponseDTO getPassengerDetails(Long id) {

        Passenger passenger = passengerRepository.findById(id).orElse(null);

        List<CarRentalDTO> cars = carRentalFeignClient.getRentalCarDetails();

        PassengerCarResponseDTO response = new PassengerCarResponseDTO();

        response.setId(passenger.getId());
        response.setName(passenger.getName());
        response.setEmail(passenger.getEmail());
        response.setPhone(passenger.getPhone());
        response.setCars(cars);

        return response;
    }

    // Fallback method when car-rental-service is down
    public PassengerCarResponseDTO fallbackGetPassengerDetails(Long id, Exception ex) {

        Passenger passenger = passengerRepository.findById(id).orElse(null);

        PassengerCarResponseDTO response = new PassengerCarResponseDTO();

        response.setId(passenger.getId());
        response.setName(passenger.getName());
        response.setEmail(passenger.getEmail());
        response.setPhone(passenger.getPhone());

        response.setCars(Collections.emptyList());
        response.setMessage("Car rental service is currently unavailable");

        return response;
    }
}