package com.demo.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class CarTest {

    @Test
    public void testSerialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        objectMapper.writeValue(new File("target/car.json"), car);
        String carAsString = objectMapper.writeValueAsString(car);
        System.out.println(carAsString);
    }

    @Test
    public void testDeserialization() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = objectMapper.readValue(new File("target/car.json"), Car.class);
        String carAsString = objectMapper.writeValueAsString(car);
        System.out.println(carAsString);

        JsonNode jsonNode = objectMapper.readTree(new File("target/car.json"));
        String color = jsonNode.get("color").asText();
        System.out.println(color);
    }
}