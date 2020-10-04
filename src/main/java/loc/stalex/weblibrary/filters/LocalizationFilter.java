package loc.stalex.weblibrary.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocalizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getSession().getAttribute("lang") == null) {
            req.getSession().setAttribute("lang", "en");
        }

        if (req.getParameter("switch_lang") != null) {
            req.getSession().setAttribute("lang", req.getParameter("switch_lang"));
        }

        chain.doFilter(request, response);
    }
}
