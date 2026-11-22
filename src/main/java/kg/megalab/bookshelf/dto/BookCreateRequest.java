
package kg.megalab.bookshelf.dto;

import jakarta.validation.constraints.*;

public record BookCreateRequest(
        @NotBlank
        @Size(max = 200)
        String title,

        @NotBlank
        @Pattern(regexp = "^(97[89])?\\d{9}[\\dX]$", message = "Некорректный ISBN")
        String isbn,

        @Min(1450)
        @Max(2100)
        Integer publishedYear,

        @Min(1)
        @Max(1000)
        int totalCopies
)
{
}
