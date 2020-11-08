package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Product;

import java.util.List;

public interface ProductRepository extends GenRepository<Product>{
    List<Product> findProductByName(String name);

    List<Product> findProductsByTag(String tag);

    List<Product> findProductsByIncreasePrice();

    List<Product> findProductsByDecreasePrice();

    List<Product> findProductsByIncreaseWeight();

    List<Product> findProductsByDecreaseWeight();
}
