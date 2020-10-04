package loc.stalex.weblibrary.command;

import loc.stalex.weblibrary.exception.InvalidDataException;
import loc.stalex.weblibrary.service.UserService;
import loc.stalex.weblibrary.utility.URLS;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class CommandRegistration implements Command {

    private final UserService userService;

    public CommandRegistration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (Optional.ofNullable(request.getParameter("email")).isEmpty()) {
            return URLS.REGISTRATION.getUrl();
        }

        try {
            userService.saveUser(request);
        } catch (InvalidDataException e) {
            request.setAttribute("regError", true);
            return URLS.REGISTRATION.getUrl();
        } catch (SQLException throwables) {
            request.setAttribute("regError", true);
            request.setAttribute("userExist", "error.userexist");
            return URLS.REGISTRATION.getUrl();
        }

        return URLS.REDIRECT.getUrl() + URLS.PROFILE.getUrl();
    }
}
