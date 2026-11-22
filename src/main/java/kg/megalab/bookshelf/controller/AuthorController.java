
package kg.megalab.bookshelf.controller;

import jakarta.validation.Valid;
import kg.megalab.bookshelf.dto.AuthorCreateRequest;
import kg.megalab.bookshelf.dto.AuthorResponse;
import kg.megalab.bookshelf.dto.AuthorUpdateRequest;
import kg.megalab.bookshelf.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController
{
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponse create(@Valid @RequestBody AuthorCreateRequest request)
    {
        return authorService.create(request);
    }

    @GetMapping
    public List<AuthorResponse> findAll()
    {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorResponse findById(@PathVariable Long id)
    {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public AuthorResponse update(@PathVariable Long id, @Valid @RequestBody AuthorUpdateRequest request)
    {
        return authorService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    {
        authorService.delete(id);
    }
}
