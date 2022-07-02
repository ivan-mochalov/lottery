package com.example.lottery.mapping;

import com.example.lottery.dto.WinnerDto;
import com.example.lottery.entity.Participant;
import com.example.lottery.entity.Winner;
import org.springframework.stereotype.Component;

@Component
public class WinnerMapper {

    public Winner from(Participant participant, Integer winningsAmount) {
        return Winner.builder()
                .firstName(participant.getFirstName())
                .lastName(participant.getLastName())
                .age(participant.getAge())
                .city(participant.getCity())
                .externalId(participant.getExternalId())
                .participatedAt(participant.getCreatedAt())
                .winningsAmount(winningsAmount)
                .build();
    }

    public WinnerDto from(Winner winner) {
        return WinnerDto.builder()
                .firstName(winner.getFirstName())
                .lastName(winner.getLastName())
                .age(winner.getAge())
                .city(winner.getCity())
                .externalId(winner.getExternalId())
                .winningsAmount(winner.getWinningsAmount())
                .build();
    }
}
