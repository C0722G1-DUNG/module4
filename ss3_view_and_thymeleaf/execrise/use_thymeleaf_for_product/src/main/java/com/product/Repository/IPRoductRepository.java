package com.product.Repository;

import com.product.model.Product;

import java.util.List;

public interface IPRoductRepository {
    List<Product> findAll();
    void Delete(int id);
    Product findById(int id);
    void update(Product product);
}
