package com.diverger.starwars.infrastructure.adapter.out.exceptions;

public class FilmNotFoundException extends RuntimeException{
    public FilmNotFoundException(String message) {
        super(message);
    }
}
