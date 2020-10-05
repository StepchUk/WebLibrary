package loc.stalex.weblibrary.service;

import loc.stalex.weblibrary.dao.BookDao;
import loc.stalex.weblibrary.dao.BookDaoImpl;
import loc.stalex.weblibrary.dao.ConnectionPool;
import loc.stalex.weblibrary.model.Book;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final BookDao bookDao = new BookDaoImpl(ConnectionPool.getInstance().getConnection());

    public List<Book> getBooks(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return bookDao.getAllBooks();
        }

        //TODO: NullPointerException wen switch language
        if (request.getParameterMap().isEmpty() ||
                request.getParameter("type").isEmpty() ||
                request.getParameter("text").isEmpty()) {
            return bookDao.getAllBooks();
        }

        return getBooksBySearchType(request);
    }

    public List<Book> getBooksByAuthor(HttpServletRequest request) {
        return bookDao.getBooksByAuthor(request.getParameter("text"));
    }

    public List<Book> getBookByTitle(HttpServletRequest request) {
        return bookDao.getBookByTitle(request.getParameter("text"));
    }

    private List<Book> getBooksBySearchType(HttpServletRequest request) {
        List<Book> bookList = new ArrayList<>();

        if ("author".equals(request.getParameter("type"))) {
            bookList = getBooksByAuthor(request);
        }

        if ("title".equals(request.getParameter("type"))) {
            bookList = getBookByTitle(request);
        }

        return bookList;
    }
}
