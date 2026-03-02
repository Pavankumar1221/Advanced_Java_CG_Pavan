package in.cg.main.services;

import java.util.List;

import in.cg.main.entities.User;

public interface UserServices  {
	public User adduserDetails(User u);
	
	List<User> getAllUsers();
	
	User getUserById(int id);
	
	
	 User updateUser(int id, User u1);

	 void deleteUser(int id);
}
