package loc.stalex.weblibrary.command;

import loc.stalex.weblibrary.utility.URLS;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandLogout implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String oldUrl = request.getParameter("old-url");

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return URLS.REDIRECT.getUrl() + (oldUrl.isEmpty() ? "/" : oldUrl);
    }
}
