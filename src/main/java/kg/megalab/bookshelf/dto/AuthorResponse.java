
package kg.megalab.bookshelf.dto;

public record AuthorResponse(
        Long id,
        String fullName,
        Integer birthYear
)
{
}
