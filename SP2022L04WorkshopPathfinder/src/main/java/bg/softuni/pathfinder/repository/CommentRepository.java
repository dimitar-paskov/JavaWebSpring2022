/**
 * @author dimitar
 *
 */
package bg.softuni.pathfinder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.pathfinder.model.Comment;
import bg.softuni.pathfinder.model.Route;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	Optional<List<Comment>> findAllByRoute(Route route);

}
