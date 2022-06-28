package com.example.lottery.api;

import com.example.lottery.dto.WinnerDto;
import com.example.lottery.mapping.WinnerMapper;
import com.example.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/winners")
@RequiredArgsConstructor
public class WinnerController {

    private final WinnerService service;
    private final WinnerMapper mapper;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<WinnerDto> getAllWinners() {
        return service.getAllWinners().stream().map(mapper::from).collect(Collectors.toList());
    }
}
