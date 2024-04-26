package kz.kstu.ilkov.coursework.exception;

public class InvalidMinRaitingException extends Exception {
    public InvalidMinRaitingException(String errorMessage) {
        super(errorMessage);
    }
}