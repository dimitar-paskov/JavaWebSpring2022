/**
 * @author dimitar
 *
 */
package bg.softuni.pathfinder.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bg.softuni.pathfinder.repository.UserRepository;

@Service
public class PathfinderUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;

	public PathfinderUserDetailsService(UserRepository userRepository ) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =  userRepository.findByUsername(username)
				.map(u -> new User(u.getUsername(), u.getPassword(),
						u.getRoles().stream()
						.map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName().name())).toList() )
						)
				.orElseThrow(()->new UsernameNotFoundException(username + " was not found"));
		
		return user;
				
	}

}
