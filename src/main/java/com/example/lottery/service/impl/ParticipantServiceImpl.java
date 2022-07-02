package com.example.lottery.service.impl;

import com.example.lottery.entity.Participant;
import com.example.lottery.repository.ParticipantRepository;
import com.example.lottery.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;

    @Override
    public void createParticipant(Participant participant) {
        participant = repository.save(participant);
        log.info("Saved new participant: {}", participant);
    }

    @Override
    public List<Participant> getAllParticipants() {
        log.info("Retrieving all participants");
        return repository.findAll();
    }

    @Override
    public void deleteAllParticipants() {
        log.info("Deleting all participants");
        repository.deleteAll();
    }
}
