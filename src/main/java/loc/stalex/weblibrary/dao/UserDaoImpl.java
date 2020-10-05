package loc.stalex.weblibrary.dao;

import loc.stalex.weblibrary.model.Role;
import loc.stalex.weblibrary.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    public static final String SQL_NEW_USER =
            "insert into users (first_name, last_name, email, password, role) values (?, ?, ?, ?, ?)";
    public static final String SQL_SELECT_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

    private final Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = Optional.empty();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = Optional.of(new User(
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            Role.valueOf(resultSet.getString("role").toUpperCase())
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void createNewUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_NEW_USER);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole().name());

        int id = preparedStatement.executeUpdate();
    }
}
