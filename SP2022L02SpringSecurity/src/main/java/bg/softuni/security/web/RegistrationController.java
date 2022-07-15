package bg.softuni.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bg.softuni.security.model.dto.UserRegisterDto;
import bg.softuni.security.service.UserService;

@Controller
public class RegistrationController {
	
	
	
	private final UserService userService;

	public RegistrationController(UserService userService) {
		this.userService = userService;
	}

  @GetMapping("/users/register")
  public String register() {
    return "auth-register";
  }
  

  @PostMapping("/users/register")
  public String register(UserRegisterDto userRegisterDto) {
	  
	  userService.registerAndLogin(userRegisterDto);
	  
    return "redirect:/";
  }
}
