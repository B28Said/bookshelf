
package kg.megalab.bookshelf.service;

import kg.megalab.bookshelf.dto.AuthorCreateRequest;
import kg.megalab.bookshelf.dto.AuthorUpdateRequest;
import kg.megalab.bookshelf.dto.AuthorResponse;
import kg.megalab.bookshelf.entity.Author;
import kg.megalab.bookshelf.mapper.AuthorMapper;
import kg.megalab.bookshelf.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import kg.megalab.bookshelf.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class AuthorService
{
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper)
    {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorResponse create(AuthorCreateRequest request)
    {
        Author author = new Author(
                request.fullName(),
                request.birthYear()
        );

        Author savedAuthor = authorRepository.save(author);

        return authorMapper.toResponse(savedAuthor);
    }

    public List<AuthorResponse> findAll()
    {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }

    public AuthorResponse findById(Long id)
    {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Автор с ID " + id + " не найден"
                ));

        return authorMapper.toResponse(author);
    }

    public AuthorResponse update(Long id, AuthorUpdateRequest request)
    {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Автор с ID " + id + " не найден"
                ));

        author.updateDetails(request.fullName(), request.birthYear());

        Author updatedAuthor = authorRepository.save(author);

        return authorMapper.toResponse(updatedAuthor);
    }

    public void delete(Long id)
    {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Автор с ID " + id + " не найден"
                ));

        authorRepository.delete(author);
    }
}
