/**
 * @author dimitar
 *
 */
package bg.softuni.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
//	@GetMapping("/hello")
//	public String hello(Model model) {
//		model.addAttribute("num", 3);
//		return "helloworld";
//	}
	
//	@GetMapping("/hello")
//	public String hello(ModelMap model) {
//		model.addAttribute("num", 3);
//		return "helloworld";
//	}
	
//	@GetMapping("/hello")
//	public ModelAndView hello(ModelAndView modelAndView) {
//		modelAndView.addObject("num", 3);
//		modelAndView.setViewName("helloworld");
//		return modelAndView;
//	}
	
	@GetMapping("/hello")
	public String hello(Model model, @RequestParam("num") Integer num) {
		model.addAttribute("num", num);
//		return "helloworld.html"; OK if there is .html
		return "helloworld.html";
	}
	
	@PostMapping("/hello")
	public String hello() {
		
		return "helloworld";
	}

}
