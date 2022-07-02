package com.example.lottery.api;

import com.example.lottery.exception.NotEnoughParticipantsException;
import com.example.lottery.service.LotteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/launches")
@RequiredArgsConstructor
public class LotteryController {

    private final LotteryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createLaunch() {
        try {
            service.createLaunch();
        } catch (NotEnoughParticipantsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
