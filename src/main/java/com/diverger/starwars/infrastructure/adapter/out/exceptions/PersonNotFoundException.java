package com.diverger.starwars.infrastructure.adapter.out.exceptions;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String message) {
        super(message);
    }
}
