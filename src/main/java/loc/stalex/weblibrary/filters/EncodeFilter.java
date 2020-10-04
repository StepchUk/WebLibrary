package loc.stalex.weblibrary.filters;

import javax.servlet.*;
import java.io.IOException;

public class EncodeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
}
