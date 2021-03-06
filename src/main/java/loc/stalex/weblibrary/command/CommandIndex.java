package loc.stalex.weblibrary.command;

import loc.stalex.weblibrary.utility.URLS;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandIndex implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        return URLS.MAIN.getUrl();
    }
}
