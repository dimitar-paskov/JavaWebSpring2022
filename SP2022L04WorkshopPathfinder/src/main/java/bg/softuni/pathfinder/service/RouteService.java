package bg.softuni.pathfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.pathfinder.exceptions.RouteNotFoundException;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.views.RouteDetailsView;
import bg.softuni.pathfinder.model.views.RouteIndexView;
import bg.softuni.pathfinder.repository.RouteRepository;

@Service
public class RouteService {
    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getMostCommented() {
        return routeRepository.findMostCommented();
    }
    
    public List<RouteIndexView> getAllRoutes(){
		
		return routeRepository.findAll().stream().map(route -> new RouteIndexView(
				route.getId(),
				route.getName(),
				route.getDescription(),
				route.getPictures().stream().findFirst().get().getUrl()
    			)).toList();
    	
    }
    
    public RouteDetailsView getRoute(Long id) {
    	
    	return routeRepository.findById(id).map(route -> new RouteDetailsView(
    			route.getId(),
    			route.getGpxCoordinates(),
    			route.getLevel().name(),
    			route.getName(),
    			route.getDescription(),
    			route.getAuthor().getFullName(),
    			route.getVideoUrl(), 
    			route.getPictures().stream().map(Picture::getUrl).toList()
    			)).orElseThrow(RouteNotFoundException::new);
    	
    }
}
