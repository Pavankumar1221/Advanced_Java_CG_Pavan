package in.cg.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import in.cg.dto.CarRentalDTO;

@FeignClient(name = "CAR-RENTAL-SERVICE")
public interface CarRentalFeignClient {

    @GetMapping("/cars/rentalcardetails")
    List<CarRentalDTO> getRentalCarDetails();

}