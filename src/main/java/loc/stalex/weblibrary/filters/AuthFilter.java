package loc.stalex.weblibrary.filters;

import loc.stalex.weblibrary.model.Role;
import loc.stalex.weblibrary.model.User;
import loc.stalex.weblibrary.utility.SecurityUtility;
import loc.stalex.weblibrary.utility.Utility;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        resp.setHeader("Cache-Control","no-store");
        resp.setHeader("Pragma","no-cache");
        resp.setHeader ("Expires", "0");

        String path = Utility.parseUrl(req);

        HttpSession session = req.getSession();
        User auth = (User) session.getAttribute("user");
        if (auth != null && (path.contains("login") || path.contains("registration"))) {
            resp.sendRedirect("/");
            return;
        }

        SecurityUtility securityUtility = new SecurityUtility();

        Role role = auth == null ? Role.GUEST : auth.getRole();
        if (securityUtility.isForbiddenRequest(path, role)) {
            if (Role.GUEST.equals(role)) {
                resp.sendRedirect("/login");
            } else {
                resp.sendRedirect("/error");
            }
            return;
        }

        chain.doFilter(req, resp);
    }
}
