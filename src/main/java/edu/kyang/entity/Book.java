package edu.kyang.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Book.
 */
@Entity(name = "Book")
@Table(name = "book") // case sensitive!
public class Book {
    private String title;

    @Column(name = "author_id", nullable = false)
    private int authorid;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    private String isbn;

    @Column(name = "publication_year")
    private int publicationYear;

    /**
     * Bidirectional @OneToMany
     The bidirectional @OneToMany association also requires a @ManyToOne association on the child side.
     Source: http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#associations-one-to-many
     */
    // Add the proper annotation - remember in this scenario, an author may have many books
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

    /**
     * @param
     */
    public Book() {
    }

    public Book(String title, int authorid, String isbn, int publicationYear, Author author) {
        this.title = title;
        this.authorid = authorid;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorid=" + authorid +
                ", id=" + id +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", author=" + author +
                '}';
    }
}
