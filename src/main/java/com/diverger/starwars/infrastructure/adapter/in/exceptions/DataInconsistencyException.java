package com.diverger.starwars.infrastructure.adapter.in.exceptions;

public class DataInconsistencyException extends RuntimeException {

    public DataInconsistencyException(String message) {
        super(message);
    }
}
