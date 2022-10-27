package com.demo.model;

import javax.persistence.*;

@Entity
public class OderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long bookRentalCode;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public OderBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBookRentalCode() {
        return bookRentalCode;
    }

    public void setBookRentalCode(long bookRentalCode) {
        this.bookRentalCode = bookRentalCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
