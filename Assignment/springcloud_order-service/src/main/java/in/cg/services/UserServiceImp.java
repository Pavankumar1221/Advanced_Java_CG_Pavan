package in.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.dto.UserDto;
import in.cg.entities.User;
import in.cg.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository us;

    @Override
    public String addUser(UserDto dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setCity(dto.getCity());

        us.save(user);

        return "User saved successfully";
    }

	@Override
	public List<User> getUserOrder() {
		// TODO Auto-generated method stub
		return us.findAll();
	}
    
	
	
    
    
    
}