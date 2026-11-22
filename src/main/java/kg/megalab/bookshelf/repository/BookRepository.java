
package kg.megalab.bookshelf.repository;

import kg.megalab.bookshelf.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>
{
    boolean existsByIsbn(String isbn);
}
