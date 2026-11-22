package kg.megalab.bookshelf.service;

import kg.megalab.bookshelf.dto.BookCreateRequest;
import kg.megalab.bookshelf.dto.BookResponse;
import kg.megalab.bookshelf.dto.BookUpdateRequest;
import kg.megalab.bookshelf.entity.Book;
import kg.megalab.bookshelf.mapper.BookMapper;
import kg.megalab.bookshelf.repository.BookRepository;
import org.springframework.stereotype.Service;
import kg.megalab.bookshelf.exception.BusinessRuleException;
import kg.megalab.bookshelf.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookResponse> findAll()
    {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }


    public BookResponse findById(Long id)
    {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Книга с ID " + id + " не найдена"));

        return bookMapper.toResponse(book);
    }



    public BookResponse update(Long id, BookUpdateRequest request)
    {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Книга с ID " + id + " не найдена"));

        if (!book.getIsbn().equals(request.isbn())
                && bookRepository.existsByIsbn(request.isbn()))
        {
            throw new BusinessRuleException("Книга с таким ISBN уже существует");
        }

        book.changeTotalCopies(request.totalCopies());

        book.updateDetails(
                request.title(),
                request.isbn(),
                request.publishedYear()
        );

        Book updatedBook = bookRepository.save(book);

        return bookMapper.toResponse(updatedBook);
    }


    public BookResponse create(BookCreateRequest request)
    {
        if(bookRepository.existsByIsbn(request.isbn())){
            throw new IllegalArgumentException("Книга с таким ISBN уже существует");
        }

        Book book = new Book(
                request.title(),
                request.isbn(),
                request.publishedYear(),
                request.totalCopies()
        );
        Book savedBook = bookRepository.save(book);

        return bookMapper.toResponse(savedBook);
    }


    public void delete(Long id)
    {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Книга с ID " + id + " не найдена"
                ));

        bookRepository.delete(book);
    }

}
