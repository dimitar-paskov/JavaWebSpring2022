/**
 * @author dimitar
 *
 */
package bg.softuni.mobilele.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.entity.UserRoleEntity;
import bg.softuni.mobilele.model.user.MobiLeleUserDetails;
import bg.softuni.mobilele.repository.UserRepository;

public class MobiLeleUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;

	public MobiLeleUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByEmail(username).map(this::map)
		.orElseThrow(()->new UsernameNotFoundException("User with email" + username + " not found"));

	}
	
	private UserDetails map(UserEntity userEntity) {
		
		return new MobiLeleUserDetails( 
				
				userEntity.getPassword(), 
				userEntity.getEmail(), 
				userEntity.getFirstName(), 
				userEntity.getLastName(),
				userEntity.getUserRoles().stream().map(this::map).toList()
			);
		
		
//		return User.builder()
//				.username(userEntity.getEmail())
//				.password(userEntity.getPassword())
//				.authorities(userEntity.getUserRoles().stream().map(this::map).toList())
//				.build();

		
	}
	
	private GrantedAuthority map(UserRoleEntity userRole) {
		
		return new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole().name());
		
	}

}
