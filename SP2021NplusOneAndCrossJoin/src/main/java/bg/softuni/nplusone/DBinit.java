/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bg.softuni.nplusone.model.nplus1.RoleEntity;
import bg.softuni.nplusone.model.nplus1.UserEntity;
import bg.softuni.nplusone.repository.RoleRepository;
import bg.softuni.nplusone.repository.UserRepository;

@Component
public class DBinit implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;


	public DBinit(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository; 
		// TODO Auto-generated constructor stub
		this.roleRepository = roleRepository;
	}
	


	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		initUsers();
		//initPosts();
	}
	
	
	private void initUsers() {
		
		if(userRepository.count() == 0) {
			
			RoleEntity adminRole = new RoleEntity();
			adminRole.setName("ADMIN");
			
			RoleEntity userRole = new RoleEntity();
			userRole.setName("USER");
			
			adminRole = roleRepository.save(adminRole);
			userRole = roleRepository.save(userRole);
			
			UserEntity user1 = new UserEntity();
			user1.setName("Lucho");
			user1.setRoles(List.of(adminRole, userRole)); 
			
			UserEntity user2 = new UserEntity();
			user2.setName("Pesho");
			user2.setRoles(List.of(adminRole));
			
			userRepository.saveAll(List.of(user1,user2));
			
		}
		
	}

}
