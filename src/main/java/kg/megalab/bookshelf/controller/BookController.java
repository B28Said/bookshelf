
package kg.megalab.bookshelf.controller;

import jakarta.validation.Valid;
import kg.megalab.bookshelf.dto.BookCreateRequest;
import kg.megalab.bookshelf.dto.BookResponse;
import kg.megalab.bookshelf.dto.BookUpdateRequest;
import kg.megalab.bookshelf.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController
{
    private final BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@Valid @RequestBody BookCreateRequest request)
    {
        return bookService.create(request);
    }

    @GetMapping
    public List<BookResponse> findAll()
    {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable Long id)
    {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @Valid @RequestBody BookUpdateRequest request)
    {
        return bookService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    {
        bookService.delete(id);
    }
}
