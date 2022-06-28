package com.example.lottery.mapping;

import com.example.lottery.dto.ParticipantDto;
import com.example.lottery.entity.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

    public Participant from(ParticipantDto dto) {
        return Participant.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .city(dto.getCity())
                .build();
    }

    public ParticipantDto from(Participant participant) {
        return ParticipantDto.builder()
                .name(participant.getName())
                .age(participant.getAge())
                .city(participant.getCity())
                .build();
    }
}
