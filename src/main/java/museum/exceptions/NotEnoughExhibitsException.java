package museum.exceptions;

public class NotEnoughExhibitsException extends RuntimeException {
    public NotEnoughExhibitsException(String message) {
        super(message);
    }
}
