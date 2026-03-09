package in.cg.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.cg.main.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserName(String userName);
}
