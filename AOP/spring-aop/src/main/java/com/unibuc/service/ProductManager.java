package com.unibuc.service;

import com.unibuc.model.Product;
import com.unibuc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager
{
    private ProductRepository productRepository;

    public ProductManager() throws InterruptedException {
        productRepository = new ProductRepository();
        Thread thread1 = new Thread(productRepository, "Thread to make sure DB is connected before UI is created");
        thread1.start();
        thread1.join();
    }


    public List<Product> getAllProducts() throws SQLException {
        System.out.println("Method getAllProducts() called");
        return this.productRepository.getProducts();
    }

    public void createProduct(Product product) throws SQLException {
        this.productRepository.addProduct(product);
        System.out.println("Method createProduct() called");
    }

    public void deleteProduct(Product product) throws SQLException {
        this.productRepository.removeProduct(product);
        System.out.println("Method deleteProduct() called");
    }

    public void updateProduct(Product product) throws SQLException
    {
        this.productRepository.updateProduct(product);
        System.out.println("Method updateProduct() called");
    }
}
