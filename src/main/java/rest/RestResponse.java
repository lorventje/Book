package rest;

import domain.Book;

import java.util.List;

public class RestResponse {
    private List<Book> books;


    public RestResponse() {}

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
