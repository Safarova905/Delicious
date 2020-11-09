package ru.kpfu.itis.dao;

import java.util.List;

public abstract class GenDao<T> {
    public abstract String insert(T adr);

    public abstract T findById(int id);

    public abstract void update(T adr);

    public abstract List<T> findAll();
}
