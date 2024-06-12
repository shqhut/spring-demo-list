package com.shq.demo.orderFeign.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

class JacksonDecoder implements Decoder {
    private final ObjectMapper mapper;

    JacksonDecoder() {
        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {

        if (response.status() == 404) {
            return Util.emptyValueOf(type);
        }

        if (response.body() == null) {
            return null;
        }

        Reader reader = response.body().asReader();
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader, 1);
        }

        try {
            // Read the first byte to see if we have any data
            reader.mark(1);
            if (reader.read() == -1) {
                return null; // Eagerly returning null avoids "No content to map due to end-of-input"
            }
            reader.reset();
            return mapper.readValue(reader, mapper.constructType(type));
        } catch (RuntimeJsonMappingException e) {
            if (e.getCause() != null && e.getCause() instanceof IOException) {
                throw IOException.class.cast(e.getCause());
            }
            throw e;
        }
    }


}
