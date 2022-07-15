/**
 * @author dimitar
 *
 */
package bg.softuni.events.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import bg.softuni.events.service.OrderService;

@Controller
public class OrderController {
	 
	private final  OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/dummy/order/create")
	public String createOrder() {
		
		orderService.createOrder("3", 33);
		
		return "Hello";
		
	}

}
