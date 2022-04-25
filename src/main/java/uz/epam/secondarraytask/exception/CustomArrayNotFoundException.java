package uz.epam.secondarraytask.exception;

public class CustomArrayNotFoundException extends RuntimeException{
    public CustomArrayNotFoundException() {
    }

    public CustomArrayNotFoundException(String message) {
        super(message);
    }

    public CustomArrayNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomArrayNotFoundException(Throwable cause) {
        super(cause);
    }
}
