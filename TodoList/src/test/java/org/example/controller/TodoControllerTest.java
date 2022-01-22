package org.example.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.TodoModel;
import org.example.model.TodoRequest;
import org.example.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private TodoService todoService;

    private TodoModel expected;

    @BeforeEach
    void setup()
    {
        this.expected = new TodoModel();
        this.expected.setId(123L);
        this.expected.setTitle("TEST TITLE");
        this.expected.setOrder(0L);
        this.expected.setCompleted(false);
    }


    @Test
    void create() throws Exception {
        // todoService 가 TodoRequest 를 받으면 받은 Request 를 기반으로
        when(this.todoService.add(any(TodoRequest.class)))
                .then((i) -> {
                    TodoRequest request = i.getArgument(0, TodoRequest.class);
                    // TodoEntity 를 생성해주고 id, Title, Order, Completed 를 가져와 title 만 반환해주고
                    // 나머지는 expected 에 있는 값과 동일한 값을 반환해준다.
                    return new TodoModel(this.expected.getId(),
                                          request.getTitle(),
                                          this.expected.getOrder(),
                                          this.expected.getCompleted());
                });

        TodoRequest request = new TodoRequest();
        request.setTitle("ANY TITLE");

        // ObjectMapper 를 이용해서 Body 에 넣어준다.
        ObjectMapper mapper = new ObjectMapper();
        // request 가 String 형태로 바뀐다.
        String content = mapper.writeValueAsString(request);

        this.mvc.perform(post("/")
                // JSON 형태의 ContentType
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                // 상태값이 OK가 내려오면
                .andExpect(status().isOk())
                // jsonPath 로 Title 을 비교해본다.
                .andExpect(jsonPath("$.title").value("ANY TITLE"));
    }

    @Test
    void readOne() throws Exception {
        given(todoService.searchById(123L)).willReturn(expected);

        mvc.perform(get("/123"))
                // 상태값이 OK가 내려오면
                .andExpect(status().isOk())
                // JSON 형태의 ContentType
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // jsonPath 로 id, title, order, completed 를 비교해본다.
                .andExpect(jsonPath("$.id").value(expected.getId()))
                .andExpect(jsonPath("$.title").value(expected.getTitle()))
                .andExpect(jsonPath("$.order").value(expected.getOrder()))
                .andExpect(jsonPath("$.completed").value(expected.getCompleted()));
    }
}