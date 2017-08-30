package com.hermes.training.spring.mvc.repository;

import com.hermes.training.spring.mvc.domain.Category;
import com.hermes.training.spring.mvc.domain.Priority;
import com.hermes.training.spring.mvc.domain.Todo;
import com.hermes.training.spring.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoRepositoryStubImpl implements TodoRepository {

    private static List<Todo> todos = new ArrayList<>();
    private static long todoCount = 0;
    private static User dummyUser = new User("dummy");
    private static Category javaTraining = new Category("Java training");
    private static Category useless = new Category("Useless");
    private static Category chores = new Category("Chores");

    static {
        todos.add(new Todo(++todoCount, dummyUser, "Learn Spring MVC"));
        todos.add(new Todo(++todoCount, dummyUser, "Learn Hibernate", LocalDateTime.now().plusDays(15), javaTraining, Priority.VERY_HIGH));
        todos.add(new Todo(++todoCount, dummyUser, "Clean car", LocalDateTime.now().plusDays(5), chores, Priority.LOW));
        todos.add(new Todo(++todoCount, dummyUser, "Learn Cognos", LocalDateTime.now().plusDays(25).plusMonths(5).plusYears(15), useless, Priority.VERY_LOW));
    }

    @Override
    public List<Todo> findAllTodos() {
        return todos;
    }

    @Override
    public List<Todo> retrieveTodosFor(User user) {
        return todos.stream().filter(todo -> todo.getUser().equals(user)).collect(Collectors.toList());
    }

    @Override
    public boolean addTodo(Todo todo) {
        try {
            return todos.add(new Todo(++todoCount, todo.getUser(), todo.getDesc()));
        } catch (ClassCastException | NullPointerException | UnsupportedOperationException | IllegalArgumentException e) {
            //TODO log & return error message
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTodo(Long id) {
        try {
            return todos.remove(retrieveTodo(id));
        } catch (ClassCastException | NullPointerException | UnsupportedOperationException e) {
            //TODO log & return error message
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Todo retrieveTodo(Long id) {
        return todos.stream().filter(todo -> todo.getId().equals(id)).findFirst().get();
    }

    @Override
    public void updateDesc(Long id, String desc) {
        retrieveTodo(id).setDesc(desc);
    }

    @Override
    public void setDone(Long id) {
        retrieveTodo(id).setDone(true);
    }

    @Override
    public void updateCategory(Long id, Category category) {
        retrieveTodo(id).setCategory(category);
    }

    @Override
    public void updatePriority(Long id, Priority priority) {
        retrieveTodo(id).setPriority(priority);
    }

    @Override
    public void updateTargetDate(Long id, LocalDateTime targetDate) {
        retrieveTodo(id).setTargetDate(targetDate);
    }
}
