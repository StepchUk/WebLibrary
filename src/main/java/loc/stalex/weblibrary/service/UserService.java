package loc.stalex.weblibrary.service;

import loc.stalex.weblibrary.dao.ConnectionPool;
import loc.stalex.weblibrary.dao.UserDao;
import loc.stalex.weblibrary.dao.UserDaoImpl;
import loc.stalex.weblibrary.exception.InvalidDataException;
import loc.stalex.weblibrary.exception.LoggingException;
import loc.stalex.weblibrary.model.Role;
import loc.stalex.weblibrary.model.User;
import loc.stalex.weblibrary.utility.UserDataValidation;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class UserService {

    private final UserDao userDao = new UserDaoImpl(ConnectionPool.getInstance().getConnection());

    private final UserDataValidation userDataValidation;

    public UserService() {
        userDataValidation = new UserDataValidation();
    }

    public User getUserByEmailAndPassword(String email, String password)
            throws LoggingException {
        User user = userDao.findUserByEmail(email)
                .orElseThrow(() -> new LoggingException("error.usernotfound"));

        if (BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }

        throw new LoggingException("error.passwordincorrect");
    }

    public void saveUser(HttpServletRequest request) throws InvalidDataException, SQLException {
        User user = extractUserFromRequest(request);
        userDao.createNewUser(user);
        request.getSession().setAttribute("user", user);
    }

    private User extractUserFromRequest(HttpServletRequest request) throws InvalidDataException {
        userDataValidation.validateUser(request);

        return new User(
                0,
                request.getParameter("firstname"),
                request.getParameter("lastname"),
                request.getParameter("email"),
                BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt(10)),
                Role.USER
        );
    }
}
