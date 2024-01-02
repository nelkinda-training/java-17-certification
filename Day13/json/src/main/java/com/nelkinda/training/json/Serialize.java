package com.nelkinda.training.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.time.Instant;

class MyObject {
    String field1;
    int field2;
    Instant field3;

    MyObject() {}

    MyObject(final String field1, final int field2, final Instant field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3=" + field3 +
                '}';
    }
}

class ObjectMapperProvider {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        OBJECT_MAPPER.findAndRegisterModules();
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }
}

class WriteObject {
    public static void main(final String... args) throws IOException {
        final MyObject myObject = new MyObject("Hello", 42, Instant.now());
        ObjectMapper objectMapper = ObjectMapperProvider.getObjectMapper();
        objectMapper.writeValue(System.out, myObject);
    }
}

class ReadObject {
    public static void main(final String... args) {
        ObjectMapper objectMapper = ObjectMapperProvider.getObjectMapper();
        final String json = """
                {
                    "field1": "Hello",
                    "field2": 42,
                    "field3": "2020-05-31T12:34:56.789Z"
                }
            """;
        try {
            final MyObject myObject = objectMapper.readValue(json, MyObject.class);
            System.out.println(myObject);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
