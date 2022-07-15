/**
 * @author dimitar
 *
 */
package bg.softuni.errorhandling.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bg.softuni.errorhandling.model.CategoryDto;
import bg.softuni.errorhandling.model.ObjectNotFoundException;

@RequestMapping("/category")
@Controller
public class CategoryController {
	
	@GetMapping("/{id}")
	public String getCategoryById(@PathVariable("id") Long id, Model model) {
		CategoryDto categoryDto = getCategoryDtoById(id);
		
		if(categoryDto == null) {
			throw new ObjectNotFoundException(id);
			
		}
		
		model.addAttribute("name", categoryDto.getCategoryName());
		
		return "category";
	}
	

	
	
	private CategoryDto getCategoryDtoById(Long id) {
		
		return null;
		
	}
	
	

}
