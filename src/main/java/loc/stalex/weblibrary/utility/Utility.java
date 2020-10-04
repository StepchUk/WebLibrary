package loc.stalex.weblibrary.utility;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Utility {

    public static String parseUrl(HttpServletRequest request) {
        String path = URLDecoder.decode(
                request.getRequestURI().substring(request.getContextPath().length()), StandardCharsets.UTF_8);

        path = path.replaceFirst("/", "");

        if (path.isEmpty()) {
            path = "index";
        } else if (path.charAt(path.length() - 1) == '/') {
            path = path.substring(0, path.length() - 1);
        }

        return path;
    }
}
