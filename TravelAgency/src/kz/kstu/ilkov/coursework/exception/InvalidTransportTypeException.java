package kz.kstu.ilkov.coursework.exception;

public class InvalidTransportTypeException extends Exception {
    public InvalidTransportTypeException(String errorMessage) {
        super(errorMessage);
    }
}