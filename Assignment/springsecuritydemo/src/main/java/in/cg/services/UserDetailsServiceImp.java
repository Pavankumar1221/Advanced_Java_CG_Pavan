package in.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.cg.dto.UserDto;
import in.cg.entities.Users;
import in.cg.repositories.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user=userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not Found");
		}
		
		return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(),
					List.of(new SimpleGrantedAuthority("Role_"+user.getRole()))
				);
	}



}
