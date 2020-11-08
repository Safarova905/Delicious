package ru.kpfu.itis.service;

import ru.kpfu.itis.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    boolean userIsExist(String email);

    void addUser(User user);

    User getUser(String email);

    User getUserById(Integer id);

    void update(User user);
}
