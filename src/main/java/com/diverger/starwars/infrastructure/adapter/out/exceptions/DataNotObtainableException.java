package com.diverger.starwars.infrastructure.adapter.out.exceptions;

import com.diverger.starwars.infrastructure.adapter.out.exceptions.interfaces.DataNotObtainable;

public class DataNotObtainableException extends RuntimeException implements DataNotObtainable {

    private String field;

    public DataNotObtainableException(String message, String field) {
        super(message);
        this.field = field;
    }

    @Override
    public String getField() {
        return field;
    }

    @Override
    public void setField() {
       this.field = field;
    }
}
