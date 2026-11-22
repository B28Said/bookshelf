
package kg.megalab.bookshelf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String fullName;

    private Integer birthYear;

    protected Author()
    {
    }

    public Author(String fullName, Integer birthYear)
    {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public Long getId()
    {
        return id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public Integer getBirthYear()
    {
        return birthYear;
    }

    public void updateDetails(String fullName, Integer birthYear)
    {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }
}
