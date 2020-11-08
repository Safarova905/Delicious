package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Comment;
import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.CommentRepository;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllCommentsByUserID(User user_id) {
        return commentRepository.findAllByUserID(user_id);
    }

    @Override
    public List<Comment> getAllCommentsByDonutID(Product product_id) {
        return commentRepository.findAllByProductID(product_id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
