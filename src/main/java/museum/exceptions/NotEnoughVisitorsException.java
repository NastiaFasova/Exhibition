package museum.exceptions;

public class NotEnoughVisitorsException extends RuntimeException {
    public NotEnoughVisitorsException(String message) {
        super(message);
    }
}
