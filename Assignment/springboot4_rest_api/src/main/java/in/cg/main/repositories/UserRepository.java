package in.cg.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
