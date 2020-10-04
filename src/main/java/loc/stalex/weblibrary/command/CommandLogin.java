package loc.stalex.weblibrary.command;

import loc.stalex.weblibrary.exception.LoggingException;
import loc.stalex.weblibrary.model.User;
import loc.stalex.weblibrary.service.UserService;
import loc.stalex.weblibrary.utility.URLS;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandLogin implements Command {

    private final UserService userService;

    public CommandLogin(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null && password == null) {
            return URLS.LOGIN.getUrl();
        } else {
            try {
                User user = userService.getUserByEmailAndPassword(email, password);
                request.getSession().setAttribute("user", user);
                return URLS.REDIRECT.getUrl() + URLS.PROFILE.getUrl();
            } catch (LoggingException e) {
                request.setAttribute("loginError", e.getMessage());
                return URLS.LOGIN.getUrl();
            }
        }
    }
}
