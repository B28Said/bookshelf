
package kg.megalab.bookshelf.dto;

import jakarta.validation.constraints.*;

public record BookUpdateRequest(
        @NotBlank
        @Size(max = 200)
        String title,

        @NotBlank
        @Pattern(regexp = "^(97[89])?\\d{9}[\\dX]$")
        String isbn,

        @Min(1450)
        @Max(2100)
        Integer publishedYear,

        @Min(0)
        @Max(1000)
        int totalCopies
)
{
}
