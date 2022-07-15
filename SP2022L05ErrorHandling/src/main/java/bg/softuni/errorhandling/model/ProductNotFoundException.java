/**
 * @author dimitar
 *
 */
package bg.softuni.errorhandling.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private final Long id;

	public ProductNotFoundException(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	
	
	

}
