/**
 * @author dimitar
 *
 */
package bg.softuni.pathfinder.web.rest;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bg.softuni.pathfinder.model.dto.CommentCreationDto;
import bg.softuni.pathfinder.model.dto.CommentMessageDto;
import bg.softuni.pathfinder.model.views.CommentDisplayView;
import bg.softuni.pathfinder.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentRestController {
	
	private final CommentService commentService;
	
	
	
	public CommentRestController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@GetMapping("/{routeId}/comments")
	public ResponseEntity<List<CommentDisplayView>> getComments(@PathVariable("routeId") Long routeId){
		
		return ResponseEntity.ok(commentService.getAllCommentsForRoute(routeId));
		
	}



	@PostMapping(value = "/{routeId}/comments", consumes = "application/json", produces = "application/json" )
	public ResponseEntity<CommentDisplayView> createComment(@PathVariable("routeId") Long routeId,
			@AuthenticationPrincipal UserDetails userDetails,
			@RequestBody CommentMessageDto commentDto) {
		
		CommentCreationDto commentCreationDto = 
				new CommentCreationDto(userDetails.getUsername(), commentDto.getMessage(), routeId);
		
		CommentDisplayView comment = commentService.createComment(commentCreationDto);
		
		return ResponseEntity
				.created(URI.create(String.format("/api/%d/comments/%d", routeId, comment.getId())))
				.body(comment);
		
	}

}
