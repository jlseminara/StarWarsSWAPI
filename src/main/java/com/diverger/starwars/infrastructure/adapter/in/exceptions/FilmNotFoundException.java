package com.diverger.starwars.infrastructure.adapter.in.exceptions;

public class FilmNotFoundException extends RuntimeException{
    public FilmNotFoundException(String message) {
        super(message);
    }
}
