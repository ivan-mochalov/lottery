package com.example.lottery.service.impl;

import com.example.lottery.entity.Participant;
import com.example.lottery.exception.NotEnoughParticipantsException;
import com.example.lottery.mapping.WinnerMapper;
import com.example.lottery.service.LotteryService;
import com.example.lottery.service.ParticipantService;
import com.example.lottery.service.RandomService;
import com.example.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LotteryServiceImpl implements LotteryService {

    private static final Integer PARTICIPANTS_AMOUNT_THRESHOLD = 2;
    private static final Integer LOWER_BOUND = 1;
    private static final Integer UPPER_BOUND = 1000;

    private final ParticipantService participantService;
    private final WinnerService winnerService;
    private final WinnerMapper winnerMapper;
    private final RandomService randomService;

    @Override
    public void createLaunch() {
        log.info("Launching the new lottery...");
        List<Participant> participants = participantService.getAllParticipants();

        if (isEnough(participants)) {
            int winningsAmount = getWinningsAmount();
            int winnerIndex = getWinnerIndex(participants.size() - 1);
            Participant participant = participants.get(winnerIndex);
            log.info("Participant with id {} won {} killed racoons! {}", participant.getId(), winningsAmount, participant);

            winnerService.createWinner(winnerMapper.from(participant, winningsAmount));
            participantService.deleteAllParticipants();
        } else {
            log.warn(NotEnoughParticipantsException.ERROR_MESSAGE);
            throw new NotEnoughParticipantsException();
        }
    }

    private boolean isEnough(List<Participant> participants) {
        return !participants.isEmpty() && participants.size() >= PARTICIPANTS_AMOUNT_THRESHOLD;
    }

    private int getWinningsAmount() {
        return randomService.getRandomInteger(LOWER_BOUND, UPPER_BOUND);
    }

    private int getWinnerIndex(int participantsArrayUpperIndex) {
        return randomService.getRandomInteger(0, participantsArrayUpperIndex);
    }
}
