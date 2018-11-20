package rest;

import com.google.gson.Gson;
import domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {
    private static final Gson gson = new Gson();


    public static String getAllBooks(List<Book> books){
        RestResponse response = new RestResponse();
        List<Book> allBooks = new ArrayList<>();
        for(Book book: books){
            allBooks.add(book);
        }
        response.setBooks(allBooks);
        String output = gson.toJson(response);
        System.out.println("[Server response] " + output);
        return output;
    }
}
