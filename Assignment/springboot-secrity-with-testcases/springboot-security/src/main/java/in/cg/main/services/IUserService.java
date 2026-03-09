package in.cg.main.services;

import in.cg.main.dto.UserDto;

public interface IUserService {
	public String registerUser(UserDto dto);
	String deleteUser(int id);
}
