package com.camellia.camelliabackend.entity;

public class ErrorResponse extends RuntimeException {
    public ErrorResponse(String message)
    {
        super(message);
    }
}
