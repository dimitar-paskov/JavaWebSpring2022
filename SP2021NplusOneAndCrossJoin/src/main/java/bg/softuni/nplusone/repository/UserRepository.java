/**
 * @author dimitar
 *
 */
package bg.softuni.nplusone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.nplusone.model.nplus1.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
