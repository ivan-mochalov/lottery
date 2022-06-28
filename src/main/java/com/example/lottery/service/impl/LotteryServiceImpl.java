package com.example.lottery.service.impl;

import com.example.lottery.entity.Participant;
import com.example.lottery.exception.NotEnoughParticipantsException;
import com.example.lottery.service.LotteryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class LotteryServiceImpl implements LotteryService {

    private static final Integer LOWER_BOUND = 1;
    private static final Integer UPPER_BOUND = 1000;
    private static final Integer PARTICIPANTS_AMOUNT_THRESHOLD = 2;

    private final ParticipantServiceImpl participantService;

    @Override
    public void start() {
        log.info("Starting the new lottery...");
        List<Participant> participants = participantService.getAllParticipants();

        if (isEnough(participants)) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            Integer winningsAmount = random.nextInt(LOWER_BOUND, UPPER_BOUND);
            int winnerIndex = random.nextInt(0, participants.size() - 1);
            Participant participant = participants.get(winnerIndex);
            log.info("Participant {} won {} dead racoons!\n{}", participant.getName(), winningsAmount, participant);

            participantService.cleanUp();
        } else {
            log.info("Not enough participants to start the new lottery.");
            throw new NotEnoughParticipantsException();
        }
    }

    private boolean isEnough(List<Participant> participants) {
        return !participants.isEmpty() && participants.size() >= PARTICIPANTS_AMOUNT_THRESHOLD;
    }
}
