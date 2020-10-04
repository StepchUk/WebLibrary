package loc.stalex.weblibrary.dao;

import loc.stalex.weblibrary.model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDao {

    Optional<User> findUserByEmail(String email);

    void createNewUser(User user) throws SQLException;
}
