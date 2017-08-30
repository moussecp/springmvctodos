package com.hermes.training.spring.mvc.repository;

import com.hermes.training.spring.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryStubImpl implements UserRepository {

    private static List<User> users = new ArrayList<>();
    private static long userCount = 0;


    static {
        users.add(new User(++userCount, "EML"));
        users.add(new User(++userCount, "GLE"));
        users.add(new User(++userCount, "JBU"));
        users.add(new User(++userCount, "GTN"));
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public boolean addUser(User user) {
        try {
            return users.add(new User(++userCount, user.getUsername()));
        } catch (ClassCastException | NullPointerException | UnsupportedOperationException | IllegalArgumentException e) {
            //TODO log & return error message
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            return users.remove(retrieveUser(id));
        } catch (ClassCastException | NullPointerException | UnsupportedOperationException e) {
            //TODO log & return error message
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User retrieveUser(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    @Override
    public void updateUsername(Long id, String username) {
        retrieveUser(id).setUsername(username);
    }
}
