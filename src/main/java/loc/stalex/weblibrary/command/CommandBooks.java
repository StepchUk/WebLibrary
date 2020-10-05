package loc.stalex.weblibrary.command;

import loc.stalex.weblibrary.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandBooks implements Command {

    private final BookService bookService;

    public CommandBooks(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("books", bookService.getBooks(request));

        return "/WEB-INF/pages/books-list.jsp";
    }
}
