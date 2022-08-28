/**
 * @author dimitar
 *
 */
package bg.softuni.intro.cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.intro.cats.model.entity.OwnerEntity;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long>{

}
