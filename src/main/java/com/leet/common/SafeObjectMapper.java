package com.leet.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

/**
 * replace EBaoJsonUtils
 *
 * @author cqy
 * @since 2017/8/10.
 */
public class SafeObjectMapper {

    static final ObjectMapper SNAKE = Jackson2ObjectMapperBuilder.json()
                                                                 .failOnUnknownProperties(false)
                                                                 .featuresToDisable(WRITE_DATES_AS_TIMESTAMPS)
                                                                 .serializationInclusion(JsonInclude.Include.NON_NULL)
                                                                 .build();

    public static ObjectMapper get() {
        return SNAKE;
    }

    public static String json(Object o) {
        try {
            return SNAKE.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
