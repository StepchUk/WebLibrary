package loc.stalex.weblibrary.dao;

import loc.stalex.weblibrary.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAllBooks();

    List<Book> getBooksByAuthor(String author);

    List<Book> getBookByTitle(String title);
}
