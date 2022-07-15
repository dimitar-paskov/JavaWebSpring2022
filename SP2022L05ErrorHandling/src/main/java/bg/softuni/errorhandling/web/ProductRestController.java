/**
 * @author dimitar
 *
 */
package bg.softuni.errorhandling.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bg.softuni.errorhandling.model.ApiErrorDto;
import bg.softuni.errorhandling.model.ProductDto;
import bg.softuni.errorhandling.model.ProductNotFoundException;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
		ProductDto productDto = getProductDtoById(id);

//		uncomment for controller based exception handler
		if (productDto == null) {
			throw new ProductNotFoundException(id);

		}

		return ResponseEntity.ok(productDto);

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ ProductNotFoundException.class})
	public @ResponseBody ApiErrorDto handleRESTErrors(ProductNotFoundException ex) {
		return new ApiErrorDto(ex.getId(), "Product was not found");
	}

	private ProductDto getProductDtoById(Long id) {

		return null;

	}

}
