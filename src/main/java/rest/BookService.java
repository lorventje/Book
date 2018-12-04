package rest;

import com.google.gson.Gson;
import domain.Book;
import persistence.BookMgr;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/bookShore")
public class BookService {
    private final Gson gson = new Gson();
    private static final Logger log = Logger.getLogger(BookService.class.getName());

    public BookService() { }

    @POST
    @Path("/addBook")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addBook(String received){
        Book book = gson.fromJson(received, Book.class);
        System.out.println("[Server add book]");
        if(book == null){
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).build();
        }
        System.out.println("[Server valid model]");
        String name = book.getTitle();
        Integer pages = book.getPages();
        String ISBN = book.getISBN();

        boolean correct;
        if(name.isEmpty() || pages == 0 || ISBN.isEmpty()){
            correct = false;
        } else {
            BookMgr bookMgr = new BookMgr();
            correct = bookMgr.addBook(name, pages, ISBN);
        }
        return Response.status(200).entity(RestResponseHelper.getSuccessResponse(correct)).build();
    }

    @GET
    @Path("/allBooks")
    @Produces("application/json")
    public Response getAllBooks(){
        BookMgr bookMgr = new BookMgr();
        List<Book> books = null;
        books = bookMgr.getAllBooks();
        if (books == null || books.size() == 0){
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).build();
        }
        return Response.status(200).entity(BookResponse.getAllBooks(books)).build();
    }

    @GET
    @Path("/bookByTitle/{title}")
    @Produces("application/json")
    public Response getBookByTitle(@PathParam("title") String title){
        BookMgr bookMgr = new BookMgr();
        List<Book> books = null;
        books = bookMgr.findBooksByTitle(title);
        if (books == null){
            return Response.status(400).entity(RestResponseHelper.getErrorResponseString()).build();
        }
        return Response.status(200).entity(BookResponse.getAllBooks(books)).build();
    }
}
