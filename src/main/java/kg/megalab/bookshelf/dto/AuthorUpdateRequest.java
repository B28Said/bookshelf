
package kg.megalab.bookshelf.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorUpdateRequest(
        @NotBlank
        @Size(max = 150)
        String fullName,

        Integer birthYear
)
{
}
