package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void Delete(int id);
    Product findById(int id);
    void update(Product product);
}
