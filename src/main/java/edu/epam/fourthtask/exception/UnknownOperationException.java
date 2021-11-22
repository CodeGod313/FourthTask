package edu.epam.fourthtask.exception;

public class UnknownOperationException extends Exception {
    public UnknownOperationException() {
    }

    public UnknownOperationException(String message) {
        super(message);
    }

    public UnknownOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownOperationException(Throwable cause) {
        super(cause);
    }
}
