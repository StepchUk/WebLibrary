package loc.stalex.weblibrary.controller;

import loc.stalex.weblibrary.command.Command;
import loc.stalex.weblibrary.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = {"/"})
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = URLDecoder.decode(
                request.getRequestURI().substring(request.getContextPath().length()), StandardCharsets.UTF_8);

        path = parseUrl(path);

        request.setAttribute("path", path);

        try {
            Class.forName("loc.stalex.weblibrary.command.CommandContainer");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Command command = CommandContainer.get(path);
        String forward = command.execute(request, response);

        if (forward != null) {
            request.getRequestDispatcher(forward).forward(request, response);
        }
    }

    private String parseUrl(String path) {
        path = path.replaceFirst("/", "");

        if (path.isEmpty()) {
            path = "index";
        } else if (path.charAt(path.length() - 1) == '/') {
            path = path.substring(0, path.length() - 1);
        }

        return path;
    }
}
