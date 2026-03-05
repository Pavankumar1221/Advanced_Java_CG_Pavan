package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cg.entities.User;
import com.cg.repositories.RestRepository;

@Service
public class UserServiceImplements implements UserService{

		@Autowired
		RestRepository ur;
		
	@CacheEvict(value= {"userslist"}, allEntries = true)
	@Override
	public User addUserDetails(User u) {
		return ur.save(u);
	}
	
	
	@Cacheable(value="userslist")
	@Override
	public List<User> getAllUsers() {
//		While fetch the data for the first time we will see this sysout statement but the second time we fetch we won't see this
		System.out.println("Fetching all users from DB");
		return ur.findAll();
	}
	
	
	@CacheEvict(value = "userslist", allEntries = true)
	@Override
	public User updateUser(int id, String name) {
		Optional<User> updateEmp=ur.findById(id);
		if(updateEmp.isPresent()) {
			User emp=updateEmp.get();
			emp.setName(name);
			return ur.save(emp);
		}
		
		return null;
	}
	
	
	
	@CacheEvict(value = "userslist", allEntries = true)
	@Override
	public boolean deleteId(int id) {
		if(ur.existsById(id)) {
			ur.deleteById(id);
			return true;
		}
		return false;
	}

}
