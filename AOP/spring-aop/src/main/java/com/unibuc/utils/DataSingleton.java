package com.unibuc.utils;

import com.unibuc.controller.GuiController;
import com.unibuc.model.Product;
import com.unibuc.service.ProductManager;

import java.util.List;


public class DataSingleton {
    private static DataSingleton single_instance = null;

    GuiController guiController;
    List<Product> products;
    Product currentProduct;
    ProductManager productManager;


    private DataSingleton() {

        guiController = new GuiController();

    }

    public static DataSingleton getInstance() {
        if (single_instance == null)
            single_instance = new DataSingleton();

        return single_instance;
    }

    public GuiController getGuiController() {

        return guiController;
    }

    public void setGuiController(GuiController guiController) {
        this.guiController = guiController;
    }

    public void setProducts(List<Product> _products) {
        products = _products;

    }

    public List<Product> getProducts()
    {
        return products;
    }



    public void setCurrentProduct(Product _product)
    {
        currentProduct = _product;
    }

    public Product getCurrentProduct()
    {
        return currentProduct;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

}
