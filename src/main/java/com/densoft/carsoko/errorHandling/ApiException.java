package com.densoft.carsoko.errorHandling;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {
    private String message;

    public ApiException(String message) {
        super(message);
        this.message = message;
    }
}
