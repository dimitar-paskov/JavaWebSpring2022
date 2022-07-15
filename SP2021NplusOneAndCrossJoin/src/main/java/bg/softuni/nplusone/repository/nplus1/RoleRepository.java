/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone.repository.nplus1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.nplusone.model.nplus1.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
