package com.demo.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class StudentTest {

    @Test
    public void add() throws JsonProcessingException {
        Student bean = new Student(1, "zs", null);
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void whenSerializingUsingCustomAnnotation_thenCorrect()
            throws JsonProcessingException {
        Student bean = new Student(1, "ls", null);

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void whenDisablingAllAnnotations_thenAllDisabled()
            throws IOException {
        Student bean = new Student(1, "ww",null);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS); // 禁用注解
        String result = mapper.writeValueAsString(bean);

        System.out.println(result);
    }


}