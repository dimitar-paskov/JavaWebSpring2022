/**
 * @author dimitar
 *
 */
package bg.softuni.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bg.softuni.springmvc.model.UserDto;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@GetMapping
	public String newUser() {
	
		return "newuser";
	}
	
	@PostMapping
	public String newUser(UserDto userDto) {
		
		System.out.println("Creating new user ...  "+ userDto);
	
		return "../static/usercreated";
	}
	


}
