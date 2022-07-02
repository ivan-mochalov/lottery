package com.example.lottery.service.impl;

import com.example.lottery.feign.RandomClient;
import com.example.lottery.service.RandomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RandomServiceImpl implements RandomService {

    private static final Integer NUMBERS_REQUESTED = 1;
    private static final Integer COLUMNS = 1;
    private static final Integer BASE = 10;
    private static final String FORMAT = "plain";
    private static final String TYPE = "new";

    private final RandomClient randomClient;

    @Override
    public int getRandomInteger(int lowerBound, int upperBound) {
        log.info("Retrieving the value withing {}..{}", lowerBound, upperBound);
        Integer value = randomClient.getInteger(NUMBERS_REQUESTED, lowerBound, upperBound, COLUMNS, BASE, FORMAT, TYPE);
        log.info("Retrieved value is {}", value);
        return value;
    }
}
