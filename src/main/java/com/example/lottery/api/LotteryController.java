package com.example.lottery.api;

import com.example.lottery.service.LotteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/start")
@RequiredArgsConstructor
public class LotteryController {

    private final LotteryService service;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void startLottery() {
        service.start();
    }
}
