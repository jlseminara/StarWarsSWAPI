package com.diverger.starwars.infrastructure.adapter.out.exceptions;

public class StarshipNotFoundException extends RuntimeException {
    public StarshipNotFoundException(String message) {
        super(message);
    }
}
