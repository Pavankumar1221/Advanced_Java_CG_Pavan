package in.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	public Users findByUsername(String username);
	
}
