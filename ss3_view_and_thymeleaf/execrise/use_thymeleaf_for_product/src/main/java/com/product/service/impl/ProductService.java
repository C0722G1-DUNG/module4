package com.product.service.impl;

import com.product.Repository.IPRoductRepository;
import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IPRoductRepository ipRoductRepository;
    @Override
    public List<Product> findAllAndSearch(String nameProduct) {
        return ipRoductRepository.findAllAndSearch(nameProduct==null?"":nameProduct);
    }

    @Override
    public void Delete(int id) {
        ipRoductRepository.Delete(id);
    }

    @Override
    public Product findById(int id) {
        return ipRoductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        ipRoductRepository.update(product);
    }

    @Override
    public void create(Product product) {
        ipRoductRepository.create(product);
    }
}
