/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone.web;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import bg.softuni.nplusone.model.crossJoin.CommentEntity;
import bg.softuni.nplusone.model.crossJoin.PostEntity;
import bg.softuni.nplusone.model.crossJoin.TagEntity;
import bg.softuni.nplusone.repository.crossJoin.PostRepository;

@Controller
public class CrossJoinController {
	
	private final PostRepository postRepository; 

	public CrossJoinController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Transactional
	@GetMapping("/test-cross")
	public String testCross() {
		
		PostEntity post = postRepository.findById(1L).get();
		
		System.out.println("-----------------------1");
		
		System.out.println("------------------------");
		System.out.println(post.getPost());
		System.out.println(post.getTags().stream().map(TagEntity::getName).collect(Collectors.joining(", "))); 
		System.out.println(post.getComments().stream().map(CommentEntity::getName).collect(Collectors.joining(", ")));
		System.out.println("------------------------");		
		
		return "Hallo";
		
	}
	

}
