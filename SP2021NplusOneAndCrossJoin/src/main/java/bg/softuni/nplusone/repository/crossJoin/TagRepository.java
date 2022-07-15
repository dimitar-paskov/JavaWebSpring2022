/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone.repository.crossJoin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.nplusone.model.crossJoin.TagEntity;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
