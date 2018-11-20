package IDaos;

import domain.Book;

import java.util.List;

public interface IBookDao {
    void create(Book book);
    List<Book> getAllBooks();
}
