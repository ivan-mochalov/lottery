package com.example.lottery.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParticipantDto {

    String firstName;
    String lastName;
    Integer age;
    String city;
    String externalId;
}
