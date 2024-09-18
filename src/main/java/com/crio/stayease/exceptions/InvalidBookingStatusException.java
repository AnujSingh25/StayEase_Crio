package com.crio.stayease.exceptions;

public class InvalidBookingStatusException extends RuntimeException {

    public InvalidBookingStatusException(String message) {
        super(message);
    }
    
}
