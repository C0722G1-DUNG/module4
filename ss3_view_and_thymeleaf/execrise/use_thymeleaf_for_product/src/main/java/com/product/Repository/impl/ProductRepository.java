package com.product.Repository.impl;

import com.product.Repository.IPRoductRepository;
import com.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IPRoductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"iphone14",25,"iphone 14promax","CHINA"));
        productList.add(new Product(2,"iphone13",20,"iphone 13promax","VIỆT NAM"));
        productList.add(new Product(3,"iphone12",18,"iphone 12promax","JAPAN"));
        productList.add(new Product(4,"iphone11",12,"iphone 11promax",""));
        productList.add(new Product(5,"iphone10",8,"iphone 10promax","Dung"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void Delete(int id) {
        for (int i = 0; i <productList.size(); i++) {
            if (productList.get(i).getId()==id){
                productList.remove(productList.get(i));
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i <productList.size(); i++) {
            if (productList.get(i).getId()==id){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
       Product product1 = findById(product.getId());
       product1.setId(product.getId());
       product1.setNameProduct(product.getNameProduct());
       product1.setPriceProduct(product.getPriceProduct());
       product1.setDescriptionProduct(product.getDescriptionProduct());
       product1.setProducer(product.getProducer());
    }
}
