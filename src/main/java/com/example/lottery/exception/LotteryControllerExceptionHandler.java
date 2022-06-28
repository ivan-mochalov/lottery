package com.example.lottery.exception;

import com.example.lottery.api.LotteryController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(assignableTypes = LotteryController.class)
public class LotteryControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotEnoughParticipantsException.class)
    protected ResponseEntity<Object> notEnoughParticipantsExceptionExceptionHandler(NotEnoughParticipantsException e) {
        return new ResponseEntity<>("Not enough participants to start the lottery", HttpStatus.BAD_REQUEST);
    }
}
