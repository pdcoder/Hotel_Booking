package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundexception extends RuntimeException {

    public NotFoundexception() {
        super();
    }

    public NotFoundexception(String message) {
        super(message);
    }

    public NotFoundexception(String message, Throwable cause) {
        super(message, cause);
    }
}
