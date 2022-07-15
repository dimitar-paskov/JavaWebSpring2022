/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone.repository.crossJoin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.nplusone.model.crossJoin.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
