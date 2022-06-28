package com.example.lottery.service;

import com.example.lottery.entity.Participant;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ParticipantService {

    Long createParticipant(Participant participant);

    @Transactional(readOnly = true)
    List<Participant> getAllParticipants();

    void cleanUp();
}
