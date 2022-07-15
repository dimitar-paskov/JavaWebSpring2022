/**
 * @author dimitar
 *
 */
package bg.softuni.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bg.softuni.security.model.dto.UserRegisterDto;
import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.model.enums.UserRoleEnum;
import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.repository.UserRoleRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;
	private final PasswordEncoder passwordEncoder;
	private final UserDetailsService appUserDetailsService;
	private final String adminPass;  

	public UserService(UserRepository userRepository, 
			UserRoleRepository userRoleRepository, 
			PasswordEncoder passwordEncoder, 
			UserDetailsService appUserDetailsService,
			@Value("${app.default.admin.password}") String adminPass) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
		this.passwordEncoder = passwordEncoder;
		this.appUserDetailsService = appUserDetailsService;
		this.adminPass = adminPass; 
	}

	public void init() {

		if (userRepository.count() == 0 && userRoleRepository.count() == 0) {
			
			UserRoleEntity adminRole = new UserRoleEntity();
			adminRole.setUserRole(UserRoleEnum.ADMIN);
			
			UserRoleEntity moderatorRole = new UserRoleEntity();
			moderatorRole.setUserRole(UserRoleEnum.MODERATOR);
			
			adminRole = userRoleRepository.save(adminRole);
			moderatorRole = userRoleRepository.save(moderatorRole);
			
			initAdmin(List.of(adminRole, moderatorRole));
			initModerator(List.of(moderatorRole)); 
			initUser(List.of());


		}

	}
	
	public void registerAndLogin(UserRegisterDto userRegisterDto) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(userRegisterDto.getEmail());
		userEntity.setFirstName(userRegisterDto.getFirstName());
		userEntity.setLastName(userRegisterDto.getLastName());
		userEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
		
		userRepository.save(userEntity);
		
		UserDetails userDetails = appUserDetailsService.loadUserByUsername(userEntity.getEmail());
		
		Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth); 
	}
	

	private void initAdmin(List<UserRoleEntity> roles) {
		
		UserEntity admin = new UserEntity();
		admin.setUserRoles(roles);
		admin.setFirstName("Admin");
		admin.setLastName("Adminov");
		admin.setEmail("admin@example.com");
		admin.setPassword(passwordEncoder.encode(adminPass));
		
		userRepository.save(admin);

	}

	private void initModerator(List<UserRoleEntity> roles) {
		
		UserEntity moderator = new UserEntity();
		moderator.setUserRoles(roles);
		moderator.setFirstName("Moderator");
		moderator.setLastName("Moderator");
		moderator.setEmail("moderator@example.com");
		moderator.setPassword(passwordEncoder.encode(adminPass));
		
		userRepository.save(moderator);

	}

	private void initUser(List<UserRoleEntity> roles) {
		
		UserEntity user = new UserEntity();
		user.setUserRoles(roles);
		user.setFirstName("User");
		user.setLastName("Userov");
		user.setEmail("user@example.com");
		user.setPassword(passwordEncoder.encode(adminPass));
		
		userRepository.save(user);

	}

}
