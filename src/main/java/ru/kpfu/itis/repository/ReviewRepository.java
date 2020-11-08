package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Review;
import ru.kpfu.itis.model.User;

import java.util.List;

public interface ReviewRepository extends GenRepository<Review> {
    List<Review> findAllByUserID(User id);
}
