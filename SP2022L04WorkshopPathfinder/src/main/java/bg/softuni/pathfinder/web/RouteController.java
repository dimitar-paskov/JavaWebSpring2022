/**
 * @author dimitar
 *
 */
package bg.softuni.pathfinder.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bg.softuni.pathfinder.model.views.RouteDetailsView;
import bg.softuni.pathfinder.model.views.RouteIndexView;
import bg.softuni.pathfinder.service.RouteService;

@Controller
@RequestMapping("/routes")
public class RouteController {

	private final RouteService  routeService;

	public RouteController(RouteService routeService) {
		this.routeService = routeService;
	}
	
	@GetMapping
	public String getAllRoutes(Model model) {
		
		List<RouteIndexView> routes = routeService.getAllRoutes();
		
		model.addAttribute("routes",routes);
		
		return "routes";
		
	}
	
	@GetMapping("/details/{id}")
	public String getRoute(@PathVariable("id") Long routeId, Model model) {
		
		RouteDetailsView route = routeService.getRoute(routeId);
		
		model.addAttribute("route", route);
		
		return "route-details";
	}
	
	
	
	
	
	
}
