package in.cg.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.main.entities.User;
import in.cg.main.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserServices{

	@Autowired
	UserRepository ur;
	
	
	@Override
	public User adduserDetails(User u) {
		// TODO Auto-generated method stub
		return ur.save(u);
	}
	
	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public User getUserById(int id) {
		return ur.findById(id).orElse(null);
	}
	
	// UPDATE
    @Override
    public User updateUser(int id, User u1) {

        User existing = ur.findById(id).orElse(null);

        if(existing != null) {
            existing.setName(u1.getName());
            existing.setEmail(u1.getEmail());
            existing.setCity(u1.getCity());

            return ur.save(existing);
        }

        return null;
    }

    // DELETE
    @Override
    public void deleteUser(int id) {
        ur.deleteById(id);
    }
	
}
