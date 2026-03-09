package in.cg.main.services;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.cg.main.entities.UserEntity;
import in.cg.main.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    UserEntity user = userRepository.findByUserName(username);

	    if (user == null) {
	        throw new UsernameNotFoundException("User not found");
	    }

	    return new User(
	            user.getUserName(),
	            user.getPassword(),
	            List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
	    );
	}

}
