package com.tencent.scfspringbootjava8.controller;

import com.tencent.scfspringbootjava8.model.TodoItem;
import com.tencent.scfspringbootjava8.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoRepository todoRepository;

    // Spring Boot 自动注入 repository
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/{key}")
    public TodoItem getByKey(@PathVariable("key") String key) {
        Optional<TodoItem> todo = todoRepository.findById(key);
        return todo.orElse(null);
    }

    @PostMapping
    public TodoItem create(@RequestBody TodoItem item) {
        return todoRepository.save(item);
    }

    @PutMapping("/{key}")
    public TodoItem update(@PathVariable("key") String key, @RequestBody TodoItem item) {
        if (item == null || !item.getKey().equals(key)) {
            return null;
        }
        return todoRepository.save(item);
    }

    @DeleteMapping("/{key}")
    public void delete(@PathVariable("key") String key) {
        todoRepository.deleteById(key);
    }
}
