
package kg.megalab.bookshelf.mapper;

import kg.megalab.bookshelf.dto.AuthorResponse;
import kg.megalab.bookshelf.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper
{
    public AuthorResponse toResponse(Author author)
    {
        return new AuthorResponse(
                author.getId(),
                author.getFullName(),
                author.getBirthYear()
        );
    }
}
