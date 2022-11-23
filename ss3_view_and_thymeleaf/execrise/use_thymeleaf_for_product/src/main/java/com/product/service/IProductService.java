package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllAndSearch(String nameProduct);
    void Delete(int id);
    Product findById(int id);
    void update(Product product);
    void create(Product product);
}
