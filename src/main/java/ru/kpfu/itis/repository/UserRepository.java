package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.User;

public interface UserRepository extends GenRepository<User> {
    User findByEmail(String email);


}
