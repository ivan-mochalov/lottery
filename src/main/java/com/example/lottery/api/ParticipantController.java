package com.example.lottery.api;

import com.example.lottery.dto.ParticipantDto;
import com.example.lottery.mapping.ParticipantMapper;
import com.example.lottery.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService service;
    private final ParticipantMapper mapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createParticipant(@RequestBody ParticipantDto participant) {
        service.createParticipant(mapper.from(participant));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ParticipantDto> getAllParticipants() {
        return service.getAllParticipants().stream().map(mapper::from).collect(Collectors.toList());
    }
}
