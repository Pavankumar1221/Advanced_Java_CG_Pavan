package in.cg.services;

import java.util.List;

import in.cg.dto.UserDto;
import in.cg.entities.User;

public interface UserService {
	
	public String addUser(UserDto dto);
	public List<User> getUserOrder();
	
}
