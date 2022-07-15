/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bg.softuni.nplusone.model.crossJoin.CommentEntity;
import bg.softuni.nplusone.model.crossJoin.PostEntity;
import bg.softuni.nplusone.model.crossJoin.TagEntity;
import bg.softuni.nplusone.model.nplus1.RoleEntity;
import bg.softuni.nplusone.model.nplus1.UserEntity;
import bg.softuni.nplusone.repository.crossJoin.CommentRepository;
import bg.softuni.nplusone.repository.crossJoin.PostRepository;
import bg.softuni.nplusone.repository.crossJoin.TagRepository;
import bg.softuni.nplusone.repository.nplus1.RoleRepository;
import bg.softuni.nplusone.repository.nplus1.UserRepository;

@Component
public class DBinit implements CommandLineRunner {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PostRepository postRepository;
	private final TagRepository tagRepository;
	private final CommentRepository commentRepository;

	public DBinit(UserRepository userRepository, RoleRepository roleRepository, PostRepository postRepository,
			TagRepository tagRepository, CommentRepository commentRepository) {

		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.postRepository = postRepository;
		this.tagRepository = tagRepository;
		this.commentRepository = commentRepository;

	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		initUsers();
		initPosts();
	}

	private void initPosts() { 
		
		if(postRepository.count() == 0 ) {
			PostEntity post = new PostEntity();
			post.setPost("A post");
			
			CommentEntity comment1 = new CommentEntity();
			comment1.setName("Abe eeeeei");
			comment1 = commentRepository.save(comment1);
			
			CommentEntity comment2 = new CommentEntity();
			comment2.setName("Vodeshtiq!");
			comment2 = commentRepository.save(comment2);
			
			TagEntity tag1 = new TagEntity();
			tag1.setName("tag1"); 
			tag1 = tagRepository.save(tag1);
			
			TagEntity tag2 = new TagEntity();
			tag2.setName("tag2"); 
			tag2 = tagRepository.save(tag2);
			
			post.setComments(Set.of(comment1, comment2));
			post.setTags(Set.of(tag1, tag2));
			
			postRepository.save(post);
					
			
 
		
		}
		
		
	}

	private void initUsers() {

		if (userRepository.count() == 0) {

			RoleEntity adminRole = new RoleEntity();
			adminRole.setName("ADMIN");

			RoleEntity userRole = new RoleEntity();
			userRole.setName("USER");

			adminRole = roleRepository.save(adminRole);
			userRole = roleRepository.save(userRole);

			UserEntity user1 = new UserEntity();
			user1.setName("Lucho");
			user1.setRoles(List.of(adminRole, userRole));

			UserEntity user2 = new UserEntity();
			user2.setName("Pesho");
			user2.setRoles(List.of(adminRole));

			userRepository.saveAll(List.of(user1, user2));

		}

	}

}
