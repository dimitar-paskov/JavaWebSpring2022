/**
 * @author dimitar
 *
 */
package bg.softuni.pathfinder.model.dto;

public class CommentCreationDto {
	
	private String username;
	private String message;
	private Long routeId;
	
	
	public CommentCreationDto(String username, String message, Long routeId) {
		super();
		this.username = username;
		this.message = message;
		this.routeId = routeId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Long getRouteId() {
		return routeId;
	}


	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	
	
	
	

}
