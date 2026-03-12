package in.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
