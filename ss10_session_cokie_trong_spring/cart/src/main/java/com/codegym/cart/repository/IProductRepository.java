package com.codegym.cart.repository;

import com.codegym.cart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
}
