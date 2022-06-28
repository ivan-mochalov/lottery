package com.example.lottery.service;

import com.example.lottery.entity.Winner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WinnerService {

    void createWinner(Winner winner);

    @Transactional(readOnly = true)
    List<Winner> getAllWinners();
}
