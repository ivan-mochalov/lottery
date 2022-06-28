package com.example.lottery.mapping;

import com.example.lottery.dto.WinnerDto;
import com.example.lottery.entity.Participant;
import com.example.lottery.entity.Winner;
import org.springframework.stereotype.Component;

@Component
public class WinnerMapper {

    public Winner from(Participant participant, Integer winningsAmount) {
        return Winner.builder()
                .name(participant.getName())
                .age(participant.getAge())
                .city(participant.getCity())
                .participatedAt(participant.getCreatedAt())
                .winningsAmount(winningsAmount)
                .build();
    }

    public WinnerDto from(Winner winner) {
        return WinnerDto.builder()
                .name(winner.getName())
                .age(winner.getAge())
                .city(winner.getCity())
                .winningsAmount(winner.getWinningsAmount())
                .build();
    }
}
