package com.diverger.starwars.infrastructure.adapter.in.exceptions;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
