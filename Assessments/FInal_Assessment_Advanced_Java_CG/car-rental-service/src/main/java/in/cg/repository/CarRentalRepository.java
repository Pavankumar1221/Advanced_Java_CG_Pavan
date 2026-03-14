package in.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.cg.entity.CarRental;

public interface CarRentalRepository extends JpaRepository<CarRental, Long> {

}