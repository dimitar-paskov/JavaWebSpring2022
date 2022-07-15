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

import bg.softuni.errorhandling.model.ObjectNotFoundException;
import bg.softuni.errorhandling.model.ProductDto;

@RequestMapping("/product")
@Controller
public class ProductController {
	
	@GetMapping("/{id}")
	public String getProductById(@PathVariable("id") Long id, Model model) {
		ProductDto productDto = getProductDtoById(id);
		
//		uncomment for controller based exception handler
//		if(productDto == null) {
//			throw new ProductNotFoundException(id);
//			
//		}
		
		if(productDto == null) {
			throw new ObjectNotFoundException(id);
			
		}
		
		model.addAttribute("name", productDto.getName());
		
		return "product";
	}
	
//	uncomment for controller based exception handler
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	@ExceptionHandler({ProductNotFoundException.class})
//	public ModelAndView onProductNotFound(ProductNotFoundException pnfe) {
//		
//		ModelAndView modelAndView = new ModelAndView("product-not-found");
//		modelAndView.addObject("productId", pnfe.getId());
//		
//		return modelAndView;
//		
//	}
	
	
	private ProductDto getProductDtoById(Long id) {
		
		return null;
		
	}
	

}
