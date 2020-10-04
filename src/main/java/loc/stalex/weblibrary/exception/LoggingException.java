package loc.stalex.weblibrary.exception;

public class LoggingException extends Exception {
    public LoggingException() {
        super();
    }

    public LoggingException(String message) {
        super(message);
    }

    public LoggingException(String message, Throwable cause) {
        super(message, cause);
    }
}
