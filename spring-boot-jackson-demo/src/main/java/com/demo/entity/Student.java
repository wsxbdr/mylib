package com.demo.entity;

import com.demo.annotation.CustomAnnotation;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@CustomAnnotation
public class Student {

    private Integer id;

    private String name;

    private Map<String, String> properties;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void add(String attr, String val) {
        if (Objects.isNull(properties)) {
            this.properties = new HashMap<>();
        }
        properties.put(attr, val);
    }
}
