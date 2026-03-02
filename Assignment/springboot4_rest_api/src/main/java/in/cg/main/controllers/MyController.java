package in.cg.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cg.main.entities.User;
import in.cg.main.services.UserServices;

@RestController
public class MyController {

	@Autowired
	private UserServices us;
	
	
	// CREATE USER
	@PostMapping("/User")
	public User createUser(@RequestBody User u1) {
		return us.adduserDetails(u1);
	}
	
	
	// GET ALL USERS
		@GetMapping("/users")
		public List<User> getAllUsers() {
			return us.getAllUsers();
		}

		// GET USER BY ID
		@GetMapping("/users/{id}")
		public User getUserById(@PathVariable int id) {
			return us.getUserById(id);
		}
		
		
		
		// UPDATE USER
	    @PutMapping("/User/{id}")
	    public User updateUser(@PathVariable int id,
	                           @RequestBody User u1) {
	        return us.updateUser(id, u1);
	    }

	    // DELETE USER
	    @DeleteMapping("/User/{id}")
	    public String deleteUser(@PathVariable int id) {
	        us.deleteUser(id);
	        return "User deleted successfully";
	    }
}
