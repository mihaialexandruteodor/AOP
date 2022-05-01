package com.unibuc.service;

import com.unibuc.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ProductManager
{
    public Product getProductById(Integer ProductId)
    {
        System.out.println("Method getProductById() called");
        return new Product();
    }

    public List<Product> getAllProducts()
    {
        System.out.println("Method getAllProducts() called");
        return new ArrayList<Product>();
    }

    public void createProduct(Product product)
    {
        System.out.println("Method createProduct() called");
    }

    public void deleteProduct(Integer productId)
    {
        System.out.println("Method deleteProduct() called");
    }

    public void updateProduct(Product product)
    {
        System.out.println("Method updateProduct() called");
    }
}
