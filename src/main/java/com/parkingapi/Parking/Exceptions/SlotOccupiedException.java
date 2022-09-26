package com.parkingapi.Parking.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SlotOccupiedException extends RuntimeException {
    public SlotOccupiedException(String message) {
        super(message);
    }
}
