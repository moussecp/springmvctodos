package com.hermes.training.spring.mvc.repository;

import com.hermes.training.spring.mvc.domain.Category;
import com.hermes.training.spring.mvc.domain.Priority;
import com.hermes.training.spring.mvc.domain.Todo;
import com.hermes.training.spring.mvc.domain.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository {
    List<User> findAllUsers();

    boolean addUser(User user);

    boolean deleteUser(Long id);

    User retrieveUser(Long id);

    void updateUsername(Long id, String username);
}
