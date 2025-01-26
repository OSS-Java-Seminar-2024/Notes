package com.smb.theatre.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException (String message) {
        super(message);
    }
}