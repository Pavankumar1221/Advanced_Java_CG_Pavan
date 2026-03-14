package in.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.cg.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}