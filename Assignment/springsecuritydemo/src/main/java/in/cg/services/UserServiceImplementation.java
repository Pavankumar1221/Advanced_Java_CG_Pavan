package in.cg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.cg.dto.UserDto;
import in.cg.entities.Users;
import in.cg.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserDto dto) {

        Users user = new Users();

        user.setUsername(dto.getUsername());

        // Encode password before saving
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(dto.getRole());

        userRepo.save(user);

        return "User Registered Successfully";
    }
}