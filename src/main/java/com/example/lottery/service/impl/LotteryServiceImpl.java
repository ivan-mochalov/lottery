package com.example.lottery.service.impl;

import com.example.lottery.entity.Participant;
import com.example.lottery.exception.NotEnoughParticipantsException;
import com.example.lottery.feign.RandomClient;
import com.example.lottery.mapping.WinnerMapper;
import com.example.lottery.service.LotteryService;
import com.example.lottery.service.ParticipantService;
import com.example.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LotteryServiceImpl implements LotteryService {

    private static final Integer PARTICIPANTS_AMOUNT_THRESHOLD = 2;
    private static final Integer NUMBERS_REQUESTED = 1;
    private static final Integer LOWER_BOUND = 1;
    private static final Integer UPPER_BOUND = 1000;
    private static final Integer COLUMNS = 1;
    private static final Integer BASE = 10;
    private static final String FORMAT = "plain";
    private static final String TYPE = "new";

    private final ParticipantService participantService;
    private final WinnerService winnerService;
    private final WinnerMapper winnerMapper;
    private final RandomClient randomClient;

    @Override
    public void start() {
        log.info("Starting the new lottery...");
        List<Participant> participants = participantService.getAllParticipants();

        if (isEnough(participants)) {
            Integer winningsAmount = getWinningsAmount();
            int winnerIndex = getWinnerIndex(participants.size() - 1);
            Participant participant = participants.get(winnerIndex);
            log.info("Participant {} won {} dead racoons!\n{}", participant.getName(), winningsAmount, participant);

            winnerService.createWinner(winnerMapper.from(participant, winningsAmount));
            participantService.deleteAllParticipants();
        } else {
            log.info("Not enough participants to start the new lottery.");
            throw new NotEnoughParticipantsException();
        }
    }

    private boolean isEnough(List<Participant> participants) {
        return !participants.isEmpty() && participants.size() >= PARTICIPANTS_AMOUNT_THRESHOLD;
    }

    private int getWinningsAmount() {
        return getRandomValue(LOWER_BOUND, UPPER_BOUND);
    }

    private int getWinnerIndex(int participantsArrayUpperIndex) {
        return getRandomValue(0, participantsArrayUpperIndex);
    }

    @SneakyThrows
    private int getRandomValue(int lowerBound, int upperBound) {
        return NumberFormat.getInstance()
                .parse(randomClient
                        .getRandomValue(NUMBERS_REQUESTED, lowerBound, upperBound, COLUMNS, BASE, FORMAT, TYPE))
                .intValue();
    }
}
