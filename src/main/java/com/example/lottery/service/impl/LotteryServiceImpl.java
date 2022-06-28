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

    private final ParticipantServiceImpl participantService;

    @Override
    public void start() {
        log.info("Starting the new lottery...");
        List<Participant> participants = participantService.getAllParticipants();

        if (isEnough(participants)) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            Integer winningsAmount = random.nextInt(1, 1000);
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
        return !participants.isEmpty() && participants.size() >= 2;
    }
}
