/**
 * @author dimitar
 *
 */
package bg.softuni.security.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bg.softuni.security.service.UserService;

@Component
public class AppInit implements CommandLineRunner{
	
	private final UserService userService;

	public AppInit(UserService userService) {
		this.userService = userService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(String... args) throws Exception {
		userService.init();
	}

}
