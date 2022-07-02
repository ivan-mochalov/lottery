package com.example.lottery.configuration;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import feign.Util;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public Decoder decoder() {
        return ((response, type) -> {
            String value = Util.toString(response.body().asReader(Util.UTF_8));
            JavaType javaType = TypeFactory.defaultInstance().constructType(type);
            return new ObjectMapper().readValue(value, javaType);
        });
    }
}
