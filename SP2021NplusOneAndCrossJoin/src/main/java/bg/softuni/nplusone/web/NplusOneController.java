/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import bg.softuni.nplusone.model.nplus1.UserEntity;
import bg.softuni.nplusone.repository.RoleRepository;
import bg.softuni.nplusone.repository.UserRepository;

@Controller
public class NplusOneController {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public NplusOneController(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		
	}
	
	@Transactional
	@GetMapping("/nplus1")
	public String getNplusOne() {
		
		System.out.println("----------------------");
		System.out.println("GET ALL USERS");
		List<UserEntity> allUsers = userRepository.findAll();
		System.out.println("GET ALL USERs: [" + allUsers.size() + " ]");
		
		for (UserEntity userEntity : allUsers) {
			System.out.println(userEntity.getName());
		}
		
		return "hallo";
		
		
	}

}