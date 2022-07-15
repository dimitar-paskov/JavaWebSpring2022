package bg.softuni.security.web;

//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesControllers {

  @GetMapping("/pages/all")
  public String all() {
    return "all";
  }

  @GetMapping("/pages/moderators")
//  public String moderators(@AuthenticationPrincipal UserDetails principal) {
	  public String moderators() {
    return "moderators";
  }

  @GetMapping("/pages/admins")
  public String admins() {
    return "admins";
  }
}
