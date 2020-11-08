package ru.kpfu.itis.repository;

import java.util.List;

public interface GenRepository<T> {
    List<T> findAll();
    T findById(Integer id);
    void save(T entity);
}
