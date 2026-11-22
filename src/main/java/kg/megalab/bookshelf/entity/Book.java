package kg.megalab.bookshelf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, unique = true, length = 17)
    private String isbn;

    private Integer publishedYear;

    @Column(nullable = false)
    private int totalCopies;

    @Column(nullable = false)
    private int availableCopies;

    protected Book() {
    }

    public Book(String title, String isbn, Integer publishedYear, int totalCopies)
    {
        if (totalCopies < 1)
        {
            throw new IllegalArgumentException(
                    "Количество экземпляров должно быть больше нуля"
            );
        }

        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public void changeTotalCopies(int newTotal){
        int borrowed = totalCopies - availableCopies;
        if(newTotal < borrowed){
            throw new IllegalArgumentException("Нельзя установить количество меньше числа выданных экземпляров");
        }

        this.totalCopies = newTotal;
        this.availableCopies = newTotal - borrowed;
    }

    public void updateDetails(String title, String isbn, Integer publishedYear)
    {
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
}
