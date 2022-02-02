package com.example.objectmapper;

import com.example.objectmapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-----------");

        // Text JSON - > Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // objectMapper 는 get 메소드를 활용한다.
        var user = new User("steve", 10, "010-2525-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text - > object
        // objectMapper 는 default 생성자가 꼭 필요하다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);

    }
}
