package exception;

public class MenuNotFoundException extends Exception {
    public MenuNotFoundException(String message) {
        super(message);
    }
}