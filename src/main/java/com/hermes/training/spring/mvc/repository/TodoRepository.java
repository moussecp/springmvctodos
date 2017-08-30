package com.hermes.training.spring.mvc.repository;

import com.hermes.training.spring.mvc.domain.Category;
import com.hermes.training.spring.mvc.domain.Priority;
import com.hermes.training.spring.mvc.domain.Todo;
import com.hermes.training.spring.mvc.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository {
    List<Todo> findAllTodos();

    List<Todo> retrieveTodosFor(User user);

    boolean addTodo(Todo todo);

    boolean deleteTodo(Long id);

    Todo retrieveTodo(Long id);

    void updateDesc(Long id, String desc);

    void setDone(Long id);

    void updateCategory(Long id, Category category);

    void updatePriority(Long id, Priority priority);

    void updateTargetDate(Long id, LocalDateTime targetDate);
}
