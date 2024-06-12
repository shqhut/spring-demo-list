package com.shq.demo.orderFeign.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.PropertyAccessor.ALL;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

class JacksonEncoder implements Encoder {
    private final ObjectMapper objectMapper = new ObjectMapper();

    JacksonEncoder() {
        super();
        objectMapper.findAndRegisterModules()
                .setVisibility(ALL, NONE)
                .setVisibility(FIELD, ANY).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public void encode(
        Object object, Type bodyType, RequestTemplate template
    ) throws EncodeException {

        try {
            String str = objectMapper.writeValueAsString(object);
            template.body(Request.Body.encoded(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        } catch (JsonProcessingException e) {
            throw new EncodeException(e.getMessage());
        }
    }
}
