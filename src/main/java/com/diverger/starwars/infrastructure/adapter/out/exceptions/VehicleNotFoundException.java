package com.diverger.starwars.infrastructure.adapter.out.exceptions;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
