/**
 * @author dimitar
 *
 */
package bg.softuni.errorhandling.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import bg.softuni.errorhandling.model.ObjectNotFoundException;

@ControllerAdvice
public class ObjectNotFoundAdvice {
	
	@ExceptionHandler({ObjectNotFoundException.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ModelAndView onProductNotFound(ObjectNotFoundException onfe) {
		
		ModelAndView modelAndView = new ModelAndView("object-not-found");
		modelAndView.addObject("objectId", onfe.getObjectId());
		
		return modelAndView;
		
	}
	

}
