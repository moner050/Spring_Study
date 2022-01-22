package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.example.model.TodoModel;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

// Mock 을 사용하는 이유
// 1. 외부시스템에 의존하지 않고 자체 테스트를 사용하기위해
// junit 테스트는 네트워크나 데이터베이스가 연결이 안된다고 junit 테스트가 함께 실행이 불가능하면 안되기 때문에
// 2. 실제 DB를 사용하게 되면 DB를 수정,삭제하는일이 발생 할 수 있는데 DB 에는 민감한 정보가 있을 수 있고
// 서비스에서 사용중인 DB가 함부로 변경되면 큰일나기 때문에

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void add()
    {
        // todoRepository 가 TodoEntity 첫번째 인자를 반환
        when(this.todoRepository.save(any(TodoModel.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        TodoRequest expected = new TodoRequest();
        expected.setTitle("Test title");

        TodoModel actual = this.todoService.add(expected);

        // expected 의 title 과 actual 의 title 값이 같은지 비교
        assertEquals(expected.getTitle(), actual.getTitle());
    }

    @Test
    void searchById() {
        TodoModel entity = new TodoModel();
        entity.setId(123L);
        entity.setTitle("TITLE");
        entity.setOrder(0L);
        entity.setCompleted(false);

        // findById 는 Optional 을 반환하는 메소드이니 Optional 로 Mapping 을 해준다.
        Optional<TodoModel> optional = Optional.of(entity);
        // 어떠한 id 값이 주어졌을때 optional 값을 리턴
        given(this.todoRepository.findById(anyLong())).willReturn(optional);

        TodoModel actual = this.todoService.searchById(123L);

        // optional 로 넣어준 값
        TodoModel expected = optional.get();

        // 값이 같나 비교
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getOrder(), actual.getOrder());
        assertEquals(expected.getCompleted(), actual.getCompleted());
    }

    @Test
    public void searchByFailed()
    {
        given(this.todoRepository.findById(anyLong())).willReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> {
            this.todoService.searchById(123L);
        });
    }
}