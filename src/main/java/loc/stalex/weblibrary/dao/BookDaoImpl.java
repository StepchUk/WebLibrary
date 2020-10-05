package loc.stalex.weblibrary.dao;

import loc.stalex.weblibrary.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    public static final String SQL_GET_ALL_BOOKS = "SELECT * FROM books";
    public static final String SQL_GET_BOOKS_BY_AUTHOR = "SELECT * FROM books WHERE LOWER(author) LIKE ?";
    public static final String SQL_GET_BOOKS_BY_TITLE = "SELECT * FROM books WHERE LOWER(title) LIKE ?";

    private final Connection connection;

    public BookDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_BOOKS)) {
            while (resultSet.next()) {
                books.add(
                    new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("edition"),
                        resultSet.getString("description"),
                        resultSet.getInt("edition_year")
                    )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return books;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return getBooks(SQL_GET_BOOKS_BY_AUTHOR, author);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return getBooks(SQL_GET_BOOKS_BY_TITLE, title);
    }

    private List<Book> getBooks(String sql, String value) {
        List<Book> books = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + value.toLowerCase() + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(
                        new Book(
                                resultSet.getInt("id"),
                                resultSet.getString("title"),
                                resultSet.getString("author"),
                                resultSet.getString("edition"),
                                resultSet.getString("description"),
                                resultSet.getInt("edition_year")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return books;
    }
}
