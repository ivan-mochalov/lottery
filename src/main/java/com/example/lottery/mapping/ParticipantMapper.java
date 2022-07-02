package com.example.lottery.mapping;

import com.example.lottery.dto.ParticipantDto;
import com.example.lottery.entity.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

    public Participant from(ParticipantDto dto) {
        return Participant.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .city(dto.getCity())
                .externalId(dto.getExternalId())
                .build();
    }

    public ParticipantDto from(Participant participant) {
        return ParticipantDto.builder()
                .firstName(participant.getFirstName())
                .lastName(participant.getLastName())
                .age(participant.getAge())
                .city(participant.getCity())
                .externalId(participant.getExternalId())
                .build();
    }
}
