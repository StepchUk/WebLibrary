package loc.stalex.weblibrary.utility;

import loc.stalex.weblibrary.exception.InvalidDataException;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDataValidation {

    String PASSWORD_REGEX = "[a-zA-Z0-9]{8,20}";
    String EMAIL_REGEX ="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public void validateUser(HttpServletRequest request) throws InvalidDataException {
        Map<String, String> validation = new LinkedHashMap<>();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (request.getParameter("firstname").isEmpty()) {
            validation.put("firstnameempty", "error.firstname");
        }

        if (request.getParameter("lastname").isEmpty()) {
            validation.put("lastnameempty", "error.lastname");
        }

        if (email.isEmpty() || !email.matches(EMAIL_REGEX)){
            validation.put("wrongEmailFormat", "error.emailmessage");
        }

        if(password.isEmpty() || !password.matches(PASSWORD_REGEX)){
            validation.put("wrongPasswordFormat", "error.passwordmessage");
        }

        if(confirmPassword.isEmpty() || !password.equals(confirmPassword)){
            validation.put("passwordsDontMatch", "error.passwordnotmatch");
        }

        if (!validation.isEmpty()) {
            validation.forEach((k, v) -> request.setAttribute(String.valueOf(k), v));
            throw new InvalidDataException();
        }

    }
}
