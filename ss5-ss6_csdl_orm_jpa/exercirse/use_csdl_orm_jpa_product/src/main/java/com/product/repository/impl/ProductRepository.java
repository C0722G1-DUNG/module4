package com.product.repository.impl;
//import com.mysql.cj.Session;

import com.product.repository.IPRoductRepository;
import com.product.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IPRoductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone14", 25, "iphone 14promax", "CHINA"));
        productList.add(new Product(2, "Samsung", 20, "iphone 13promax", "VIỆT NAM"));
        productList.add(new Product(3, "Nokia", 18, "iphone 12promax", "JAPAN"));
        productList.add(new Product(4, "ipad", 12, "iphone 11promax", ""));
        productList.add(new Product(5, "iphone10", 8, "iphone 10promax", "Dung"));
    }

    @Override
    public List<Product>
    findAllAndSearch(String nameProduct) {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("select p FROM Product p where nameProduct like :namex").setParameter("namex","%"+nameProduct+"%").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void Delete(int id) {
        Session session = null;
        Product product = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            product = (Product) session.createQuery(" FROM Product p where id = :id").setParameter("id",id).getSingleResult();
        session.remove(product);
//        thực hiện song phải commit để lưu lại tiến trình
        transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery(" FROM Product p where id = :id").setParameter("id",id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void create(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }finally {
            if (session!=null){
                session.close();
            }
        }

    }
}
