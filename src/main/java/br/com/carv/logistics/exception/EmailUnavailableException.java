package br.com.carv.logistics.exception;

public class EmailUnavailableException extends RuntimeException {
    public EmailUnavailableException(String message) {
        super(message);
    }
}
