package com.example.lottery.service.impl;

import com.example.lottery.entity.Winner;
import com.example.lottery.repository.WinnerRepository;
import com.example.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WinnerServiceImpl implements WinnerService {

    private final WinnerRepository repository;

    @Override
    public void createWinner(Winner winner) {
        winner = repository.save(winner);
        log.info("Saved new winner {} with id {}", winner.getName(), winner.getId());
    }

    @Override
    public List<Winner> getAllWinners() {
        log.info("Retrieving all winners");
        return repository.findAll();
    }
}
