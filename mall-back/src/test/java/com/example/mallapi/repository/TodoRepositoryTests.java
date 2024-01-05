package com.example.mallapi.repository;

import com.example.mallapi.domain.Todo;
import com.example.mallapi.dto.PageRequestDTO;
import com.example.mallapi.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Slf4j
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @Test
    public void test1() {
        Assertions.assertNotNull(todoRepository);

        log.info(todoRepository.getClass().getName());
    }

    @Test
    public void testInsert() {
        Todo todo = Todo.builder()
                .title("Title")
                .content("Content...")
                .dueDate(LocalDate.of(2024,01,30))
                .build();

      Todo result = todoRepository.save(todo);

      log.info(String.valueOf(result));
    }

    @Test
    public void testSearch1() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).build();

        log.info(String.valueOf(todoService.getList(pageRequestDTO)));
    }
}
