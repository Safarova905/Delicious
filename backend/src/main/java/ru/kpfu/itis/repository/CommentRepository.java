package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Comment;
import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.model.User;

import java.util.List;

public interface CommentRepository extends GenRepository<Comment>{
    List<Comment> findAllByUserID(User user_id);

    List<Comment> findAllByProductID(Product product_id);
}
