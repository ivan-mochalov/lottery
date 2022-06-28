package com.example.lottery.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class WinnerDto {

    String name;
    Integer age;
    String city;
    Integer winningsAmount;
}
