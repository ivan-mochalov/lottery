package com.example.lottery.feign;

import com.example.lottery.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "random",
        url = "https://www.random.org",
        path = "/integers",
        configuration = FeignConfiguration.class
)
@Component
public interface RandomClient {

    @GetMapping
    Integer getInteger(
            @RequestParam("num") Integer numbersAmount,
            @RequestParam("min") Integer minValue,
            @RequestParam("max") Integer maxValue,
            @RequestParam("col") Integer columnsAmount,
            @RequestParam("base") Integer numberBase,
            @RequestParam("format") String numberFormat,
            @RequestParam("rnd") String randomizationType
    );
}
