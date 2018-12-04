package rest;

import domain.Book;

import java.util.List;

public class RestResponse {
    private List<Book> books;
    private Book book;

    public RestResponse() {}

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
