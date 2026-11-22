
package kg.megalab.bookshelf.dto;

public record BookResponse(
        Long id,
        String title,
        String isbn,
        Integer publishedYear,
        int totalCopies,
        int availableCopies
)
{
}
