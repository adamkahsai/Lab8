package miu.edu.cs.cs425.elibrary.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    @NotBlank(message = "ISBN required")
    private String isbn;
    private String title;
    private LocalDate dateOfPublished;
    private double overdueFee;

    public Book() {
    }

    public Book(long bookId, String isbn, String title, LocalDate dateOfPublished, double overdueFee) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.dateOfPublished = dateOfPublished;
        this.overdueFee = overdueFee;
    }

    public Book(String isbn, String title, LocalDate dateOfPublished, double overdueFee) {
        this.isbn = isbn;
        this.title = title;
        this.dateOfPublished = dateOfPublished;
        this.overdueFee = overdueFee;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfPublished() {
        return dateOfPublished;
    }

    public void setDateOfPublished(LocalDate dateOfPublished) {
        this.dateOfPublished = dateOfPublished;
    }

    public double getOverdueFee() {
        return overdueFee;
    }

    public void setOverdueFee(double overdueFee) {
        this.overdueFee = overdueFee;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", dateOfPublished=" + dateOfPublished +
                ", overdueFee=" + overdueFee +
                '}';
    }
}
