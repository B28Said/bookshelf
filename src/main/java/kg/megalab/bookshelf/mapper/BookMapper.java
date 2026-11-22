
package kg.megalab.bookshelf.mapper;

import kg.megalab.bookshelf.dto.BookResponse;
import kg.megalab.bookshelf.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper
{
    public BookResponse toResponse(Book book)
    {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPublishedYear(),
                book.getTotalCopies(),
                book.getAvailableCopies()
        );
    }
}
