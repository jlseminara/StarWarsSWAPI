package com.diverger.starwars.infrastructure.adapter.in.exceptions;

public class PlanetNotFoundException extends RuntimeException{
    public PlanetNotFoundException(String message) {
        super(message);
    }
}
