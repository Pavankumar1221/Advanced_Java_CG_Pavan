package in.cg.main.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.cg.main.dto.UserDto;
import in.cg.main.entities.UserEntity;
import in.cg.main.repositories.UserRepository;

@Service
public class UserService implements IUserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String registerUser(UserDto dto) {

		UserEntity user = new UserEntity();

		user.setUserName(dto.getUserName());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(dto.getRole().toUpperCase());
		String role = dto.getRole().toUpperCase();

		if (!role.equals("USER") && !role.equals("ADMIN")) {
			throw new RuntimeException("Invalid role");
		}

		user.setRole(role);
		userRepository.save(user);
		return "User Registered Successfully";
	}

	public String deleteUser(int id) {

		if (!userRepository.existsById(id)) {
			return "User not found";
		}

		userRepository.deleteById(id);
		return "User deleted successfully";
	}
}
