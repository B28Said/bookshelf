
package kg.megalab.bookshelf.repository;

import kg.megalab.bookshelf.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>
{
}
