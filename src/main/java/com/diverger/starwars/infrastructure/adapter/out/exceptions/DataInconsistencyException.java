package com.diverger.starwars.infrastructure.adapter.out.exceptions;

public class DataInconsistencyException extends RuntimeException {

    public DataInconsistencyException(String message) {
        super(message);
    }
}
