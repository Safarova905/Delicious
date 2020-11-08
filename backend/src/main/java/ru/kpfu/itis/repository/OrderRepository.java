package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Order;
import ru.kpfu.itis.model.Product;
import ru.kpfu.itis.model.User;

import java.util.List;

public interface OrderRepository extends GenRepository<Order> {
    Order getUserOrder(User user);

    List<Product> findProducts(Order order);

    void addProduct(Order order, Product product);

    void deleteProduct(Order order, Product product);
}
