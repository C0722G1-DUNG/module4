package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface IPRoductRepository {
    List<Product> findAllAndSearch(String nameProduct);
    void Delete(int id);
    Product findById(int id);
    void update(Product product);
    void create(Product product);
}
