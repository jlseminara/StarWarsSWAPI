package com.diverger.starwars.infrastructure.adapter.out.exceptions;

public class PlanetNotFoundException extends RuntimeException{
    public PlanetNotFoundException(String message) {
        super(message);
    }
}
