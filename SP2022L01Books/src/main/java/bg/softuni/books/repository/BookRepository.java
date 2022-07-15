/**
 * @author dimitar
 *
 */
package bg.softuni.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.books.model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{

}
