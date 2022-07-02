package com.example.lottery.exception;

public class NotEnoughParticipantsException extends RuntimeException {

    public static final String ERROR_MESSAGE = "Not enough participants to start the new lottery.";

    public NotEnoughParticipantsException() {
        super(ERROR_MESSAGE);
    }
}
